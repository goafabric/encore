package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.persistence.bo.PatientBo;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<PatientBo, String> {
}
