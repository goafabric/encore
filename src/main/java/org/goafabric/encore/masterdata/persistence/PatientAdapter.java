package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.controller.dto.Patient;

public interface PatientAdapter {
    Patient getPatient(String id);

    Bundle findyFirstName(String firstName);

    Bundle findyByLastName(String lastName);

}
