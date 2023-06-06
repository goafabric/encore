# docker compose
go to /src/deploy/docker and do "./stack up" or "./stack up -native"

# mongodb
docker run --name mongodb --rm -p27017:27017 -e MONGO_INITDB_ROOT_USERNAME=mongodb -e MONGO_INITDB_ROOT_PASSWORD=mongodb mongo:6.0.4

# run jvm multi image
docker run --pull always --name encore --rm -p50500:50500 -e spring.data.mongodb.host=host.docker.internal goafabric/encore:1.0.4

# run native image
docker run --pull always --name encore-native --rm -p50500:50500 -e spring.data.mongodb.host=host.docker.internal goafabric/encore-native:1.0.4 -Xmx32m

# run native image arm
docker run --pull always --name encore-native --rm -p50500:50500 -e spring.data.mongodb.host=host.docker.internal goafabric/encore-native-arm64v8:1.0.4 -Xmx32m

# jvm with embedded h2
docker run --pull always --name encore --rm -p50500:50500 -e spring.profiles.active=jpa goafabric/encore:1.0.4

