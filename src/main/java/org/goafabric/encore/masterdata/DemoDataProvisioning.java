package org.goafabric.encore.masterdata;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.masterdata.logic.mock.MockUtil;
import org.goafabric.encore.objectstorage.dto.ObjectEntry;
import org.goafabric.encore.security.dto.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.IntStream;

import static org.goafabric.encore.masterdata.logic.mock.MockUtil.createPatient;

@Component
@Slf4j
public class DemoDataProvisioning implements CommandLineRunner {
    @Value("${database.provisioning.goals:}")
    String goals;

    private final ApplicationContext applicationContext;
    private final FhirLogic<Patient> patientLogic;
    private final FhirLogic<Practitioner> practitionerLogic;
    private final FhirLogic<Organization> organizationLogic;
    private final FhirLogic<ObjectEntry> archiveLogic;
    private final FhirLogic<Role> rolesLogic;


    public DemoDataProvisioning(
            ApplicationContext applcationContext,
            FhirLogic<Patient> patientLogic, FhirLogic<Practitioner> practitionerLogic, FhirLogic<Organization> organizationLogic
            , FhirLogic<ObjectEntry> archiveLogic, FhirLogic<Role> rolesLogic) {
        this.applicationContext = applcationContext;
        this.patientLogic = patientLogic;
        this.practitionerLogic = practitionerLogic;
        this.organizationLogic = organizationLogic;
        this.archiveLogic = archiveLogic;
        this.rolesLogic = rolesLogic;
    }

    @Override
    public void run(String... args) throws Exception {
        if (goals.contains("-import-demo-data")) {
            log.info("Importing demo data ...");
            importDemoData();
            log.info("Demo data import done ...");
        }

        if (goals.contains("-terminate")) {
            log.info("Terminating app ...");
            SpringApplication.exit(applicationContext, () -> 0); //if an exception is raised, spring will automatically terminate with 1
        }
    }

    private void importDemoData() {

        createPatientData();

        createPractitionerData();
        createOrganization();

        createRoles();

        createArchiveFiles();
    }


    private void createPatientData() {
        Faker faker = new Faker();
        patientLogic.create(MockUtil.createPatient("Homer", "Simpson", "Evergreen Terrace 742", "0245-33553"));
        IntStream.range(0, 50).forEach(i -> patientLogic.create(
                createPatient(faker.name().firstName(), faker.name().lastName(), faker.simpsons().location(), "0245-43553")
        ));
    }

    private void createPractitionerData() {
        practitionerLogic.create(MockUtil.createPractitioner("Dr Julius", "Hibbert", "Commonstreet 345", "555-520"));
        practitionerLogic.create(MockUtil.createPractitioner("Dr Marvin", "Monroe", "Psychestreet 104", "555-525"));
        practitionerLogic.create(MockUtil.createPractitioner("Dr Nick", "Riveria", "Nickstreet 221", "555-501"));
    }

    private void createRoles() {
        rolesLogic.create(Role.builder().role("Administrator").build());
        rolesLogic.create(Role.builder().role("Practitioner").build());
        rolesLogic.create(Role.builder().role("Assistant").build());
    }

    private void createOrganization() {
        organizationLogic.create(MockUtil.createOrganization());
    }

    private void createArchiveFiles() {
        archiveLogic.create(ObjectEntry.builder()
                .id(UUID.randomUUID().toString())
                .objectName("hello_world.txt")
                .objectSize("hello world".length())
                .contentType("text/plain")
                .data("hello world".getBytes())
                .build());

        archiveLogic.create(ObjectEntry.builder()
                .id(UUID.randomUUID().toString())
                .objectName("top_secret.txt")
                .objectSize("top secret".length())
                .contentType("text/plain")
                .data("top secret".getBytes())
                .build());
    }

}
