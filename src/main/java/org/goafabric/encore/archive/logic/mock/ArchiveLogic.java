package org.goafabric.encore.archive.logic.mock;

import org.goafabric.encore.archive.dto.ObjectEntry;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Profile("mock")
public class ArchiveLogic implements FhirLogic<ObjectEntry> {
    private final List<ObjectEntry> objectEntries = new ArrayList<>();

    public ArchiveLogic() {
        create(ObjectEntry.builder()
                .id(UUID.randomUUID().toString())
                .objectName("hello_world.txt")
                .objectSize("hello world".length())
                .contentType("text")
                .data("hello world".getBytes())
                .build());

        create(ObjectEntry.builder()
                .id(UUID.randomUUID().toString())
                .objectName("top_secret.txt")
                .objectSize("top secret".length())
                .contentType("text")
                .data("top secret".getBytes())
                .build());
    }

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
