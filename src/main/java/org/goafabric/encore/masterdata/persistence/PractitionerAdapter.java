package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.controller.dto.Practitioner;

public interface PractitionerAdapter {
    Practitioner getPractitioner(String id);

}
