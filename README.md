# docker compose
go to /src/deploy/docker and do "./stack up" or "./stack up -native"

# run jvm multi image
docker run --pull always --name encore --rm -p50500:50500 goafabric/encore:1.0.2-SNAPSHOT

# run native image
docker run --pull always --name encore-native --rm -p50500:50500 goafabric/encore-native:1.0.2-SNAPSHOT -Xmx32m

# run native image arm
docker run --pull always --name encore-native --rm -p50500:50500 goafabric/encore-native-arm64v8:1.0.1 -Xmx32m

# loki logger
docker run --pull always --name encore --rm -p50500:50500 --log-driver=loki --log-opt loki-url="http://host.docker.internal:3100/loki/api/v1/push" goafabric/encore:1.0.2-SNAPSHOT