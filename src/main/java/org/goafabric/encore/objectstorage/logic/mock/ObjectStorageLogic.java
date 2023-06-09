package org.goafabric.encore.objectstorage.logic.mock;

import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.objectstorage.dto.ObjectEntry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(value = "spring.cloud.aws.s3.enabled", havingValue = "false")
public class ObjectStorageLogic implements CrudLogic<ObjectEntry> {
    private final List<ObjectEntry> objectEntries = new ArrayList<>();

    @Override
    public void create(ObjectEntry objectEntry) {
        objectEntries.add(objectEntry);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll() {
        objectEntries.clear();
    }

    @Override
    public ObjectEntry getById(String id) {
        throw new IllegalStateException();
    }

    @Override
    public List<ObjectEntry> search(String search) {
        return objectEntries.stream()
                .filter(o -> o.getObjectName().toLowerCase().startsWith(search.toLowerCase())).toList();
    }
}
