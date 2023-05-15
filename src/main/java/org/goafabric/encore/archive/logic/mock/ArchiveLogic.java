package org.goafabric.encore.archive.logic.mock;

import org.goafabric.encore.archive.dto.ObjectEntry;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("mock")
public class ArchiveLogic implements FhirLogic<ObjectEntry> {
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
