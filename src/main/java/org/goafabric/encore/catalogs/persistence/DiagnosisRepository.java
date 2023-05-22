package org.goafabric.encore.catalogs.persistence;

import org.goafabric.encore.catalogs.persistence.bo.DiagnosisBo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiagnosisRepository extends CrudRepository<DiagnosisBo, String> {
    List<DiagnosisBo> findByDisplayStartsWithIgnoreCase(String display);
}
