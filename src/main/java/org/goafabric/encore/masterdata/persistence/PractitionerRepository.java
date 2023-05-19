package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.persistence.bo.PractitionerBo;
import org.springframework.data.repository.CrudRepository;

public interface PractitionerRepository extends CrudRepository<PractitionerBo, String> {
}
