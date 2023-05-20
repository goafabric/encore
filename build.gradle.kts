import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

group = "org.goafabric"
version = "1.0.3-mongo-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

val dockerRegistry = "goafabric"
val nativeBuilder = "dashaun/builder:20230225"
val baseImage = "ibm-semeru-runtimes:open-17.0.6_10-jre-focal@sha256:739eab970ff538cf22a20b768d7755dad80922a89b73b2fddd80dd79f9b880a1" //"eclipse-temurin:20_36-jdk-ubi9-minimal"

plugins {
	java
	jacoco
	id("org.springframework.boot") version "3.0.6"
	id("io.spring.dependency-management") version "1.1.0"
	id("org.graalvm.buildtools.native") version "0.9.20"
	id("com.google.cloud.tools.jib") version "3.3.1"

	id("com.vaadin") version "24.0.5"
}

jacoco { toolVersion = "0.8.9" }

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	constraints {
		implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
		implementation("org.mapstruct:mapstruct:1.5.4.Final")
		annotationProcessor("org.mapstruct:mapstruct-processor:1.5.4.Final")
		implementation("io.github.resilience4j:resilience4j-spring-boot3:2.0.2")
	}
}

dependencies {
	//web
	implementation("org.springframework.boot:spring-boot-starter-web")

	//monitoring
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("io.micrometer:micrometer-registry-prometheus")

	implementation("io.micrometer:micrometer-tracing-bridge-brave")
	implementation("io.zipkin.reporter2:zipkin-reporter-brave")
	//implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui")

	//crosscuting
	implementation("org.springframework.boot:spring-boot-starter-aop")
	//implementation("org.springframework.boot:spring-boot-starter-security")

	//code generation
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	//s3
	implementation("io.awspring.cloud:spring-cloud-aws-starter-s3:3.0.1")

	//persistence
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	if (!gradle.startParameter.taskNames.contains("nativeCompile") && (!gradle.startParameter.taskNames.contains("dockerImageNative"))) {
		developmentOnly("de.flapdoodle.embed:de.flapdoodle.embed.mongo.spring30x:4.6.2")
	}
	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo.spring30x:4.6.2")

	implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")

	/*
	implementation("org.springframework.boot:spring-boot-starter-data-jpa") {exclude("org.glassfish.jaxb", "jaxb-runtime")}
	implementation("com.h2database:h2")
	implementation("org.postgresql:postgresql")
	*/

	//code generation
	implementation("org.mapstruct:mapstruct")
	annotationProcessor("org.mapstruct:mapstruct-processor")


	//vaadin
	implementation("com.vaadin:vaadin-spring-boot-starter:24.0.5")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("net.datafaker:datafaker:1.8.1") { exclude("org.yaml", "snakeyaml") }

	//test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("ca.uhn.hapi.fhir:hapi-fhir-client-okhttp:6.4.4")
	testImplementation("ca.uhn.hapi.fhir:hapi-fhir-structures-r4:6.4.4")
}

tasks.withType<Test> {
	useJUnitPlatform()
	exclude("**/*NRIT*")
	finalizedBy("jacocoTestReport")
}

jib {
	val amd64 = com.google.cloud.tools.jib.gradle.PlatformParameters(); amd64.os = "linux"; amd64.architecture = "amd64"; val arm64 = com.google.cloud.tools.jib.gradle.PlatformParameters(); arm64.os = "linux"; arm64.architecture = "arm64"
	from.image = baseImage
	to.image = "${dockerRegistry}/${project.name}:${project.version}"
	container.jvmFlags = listOf("-Xms256m", "-Xmx256m")
	from.platforms.set(listOf(amd64, arm64))
}

tasks.register("dockerImageNative") { group = "build"; dependsOn("bootBuildImage") }
tasks.named<BootBuildImage>("bootBuildImage") {
	dependsOn("vaadinBuildFrontend")
	val nativeImageName = "${dockerRegistry}/${project.name}-native" + (if (System.getProperty("os.arch").equals("aarch64")) "-arm64v8" else "") + ":${project.version}"
	builder.set(nativeBuilder)
	imageName.set(nativeImageName)
	environment.set(mapOf("BP_NATIVE_IMAGE" to "true", "BP_JVM_VERSION" to "17", "BP_NATIVE_IMAGE_BUILD_ARGUMENTS" to "-J-Xmx4000m"))
	doLast {
		exec { commandLine("docker", "run", "--rm", nativeImageName, "-check-integrity") }
		exec { commandLine("docker", "push", nativeImageName) }
	}
}