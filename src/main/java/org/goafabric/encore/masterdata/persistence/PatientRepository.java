package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.persistence.bo.PatientBo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<PatientBo, String> {
    List<PatientBo> findByName_Family(String family);
}
