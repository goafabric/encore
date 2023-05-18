package org.goafabric.encore.masterdata.repository;

import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, String> {
}
