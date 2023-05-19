package org.goafabric.encore.masterdata.repository;

import org.goafabric.encore.masterdata.repository.bo.PatientBo;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<PatientBo, String> {
}
