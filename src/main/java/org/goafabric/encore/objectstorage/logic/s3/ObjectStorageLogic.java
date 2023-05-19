package org.goafabric.encore.objectstorage.logic.s3;

import io.awspring.cloud.autoconfigure.core.AwsAutoConfiguration;
import lombok.SneakyThrows;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.objectstorage.dto.ObjectEntry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.util.List;

@Component
@ConditionalOnProperty(value = "spring.cloud.aws.s3.enabled", havingValue = "true")
@Import(AwsAutoConfiguration.class)
public class ObjectStorageLogic implements CrudLogic<ObjectEntry> {

    private final S3Client s3Client;
    private static final String bucketName = "objects";

    public ObjectStorageLogic(S3Client s3Client) {
        this.s3Client = s3Client;
        try {
            s3Client.createBucket(CreateBucketRequest.builder().bucket(bucketName).build());
        } catch (S3Exception e) {
        }
    }

    @Override
    public void create(ObjectEntry objectEntry) {
        s3Client.putObject(PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(objectEntry.getObjectName())
                        .contentLength(objectEntry.getObjectSize())
                        .contentType(objectEntry.getContentType())
                        .build(),
                RequestBody.fromBytes(objectEntry.getData()));
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll() {
        throw new IllegalStateException("NYI");
    }

    @Override
    @SneakyThrows
    public ObjectEntry getById(String id) {
        var response = s3Client.getObject(request -> request.bucket(bucketName).key(id));

        return ObjectEntry.builder()
                .objectName(id)
                .data(response.readAllBytes())
                .build();
    }

    @Override
    public List<ObjectEntry> search(String search) {
        var contents = s3Client.listObjects(builder -> builder.bucket(bucketName)).contents();
        return contents.stream().map(c ->
                ObjectEntry.builder().objectName(c.key()).objectSize(c.size()).build())
                .filter(o -> o.getObjectName().toLowerCase().startsWith(search.toLowerCase()))
                .toList();
    }
}
