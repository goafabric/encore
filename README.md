# docker compose
go to /src/deploy/docker and do "./stack up" or "./stack up -native"

# run jvm multi image
docker run --pull always --name encore --rm -p50500:50500 -e spring.data.mongodb.host=host.docker.internal goafabric/encore:1.0.3-SNAPSHOT

# run native image
docker run --pull always --name encore-native --rm -p50500:50500 -e spring.data.mongodb.host=host.docker.internal goafabric/encore-native:1.0.3-SNAPSHOT -Xmx32m

# run native image arm
docker run --pull always --name encore-native --rm -p50500:50500 -e spring.data.mongodb.host=host.docker.internal goafabric/encore-native-arm64v8:1.0.3-SNAPSHOT -Xmx32m

# loki logger
docker run --pull always --name encore --rm -p50500:50500 --log-driver=loki --log-opt loki-url="http://host.docker.internal:3100/loki/api/v1/push" goafabric/encore:1.0.3-SNAPSHOT

# mongodb
docker run --name mongodb --rm -p27017:27017 -e MONGO_INITDB_ROOT_USERNAME=mongodb -e MONGO_INITDB_ROOT_PASSWORD=mongodb mongo:6.0.4