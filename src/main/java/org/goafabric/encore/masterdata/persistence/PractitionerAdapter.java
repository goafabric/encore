package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.controller.dto.Practitioner;

public interface PractitionerAdapter {
    void create(Practitioner practitioner);

    void delete(String id);

    Practitioner getById(String id);

}
