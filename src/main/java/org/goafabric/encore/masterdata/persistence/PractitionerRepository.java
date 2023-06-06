package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.persistence.bo.PractitionerBo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PractitionerRepository extends CrudRepository<PractitionerBo, String> {
    List<PractitionerBo> findByName_FamilyStartsWithIgnoreCase(String family);
}
