package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.controller.dto.Practitioner;

import java.util.List;

public interface PractitionerAdapter {
    void create(Practitioner practitioner);

    void delete(String id);

    void deleteAll();

    Practitioner getById(String id);

    public List<Practitioner> search(String familyName);

}
