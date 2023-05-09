package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.controller.dto.Patient;

public interface PatientAdapter {

    void create(Patient patient);

    void delete(String id);

    Patient getPatient(String id);

    Bundle findByFirstName(String firstName);

    Bundle findyByLastName(String lastName);

}
