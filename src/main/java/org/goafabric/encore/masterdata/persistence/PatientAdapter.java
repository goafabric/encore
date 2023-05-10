package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.controller.dto.Patient;

public interface PatientAdapter {

    void create(Patient patient);

    void delete(String id);

    Patient getById(String id);

    Bundle search(String lastName);

}
