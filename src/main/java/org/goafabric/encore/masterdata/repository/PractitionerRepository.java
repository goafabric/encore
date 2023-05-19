package org.goafabric.encore.masterdata.repository;

import org.goafabric.encore.masterdata.repository.bo.PractitionerBo;
import org.springframework.data.repository.CrudRepository;

public interface PractitionerRepository extends CrudRepository<PractitionerBo, String> {
}
