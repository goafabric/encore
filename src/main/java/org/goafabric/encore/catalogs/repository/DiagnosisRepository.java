package org.goafabric.encore.catalogs.repository;

import org.goafabric.encore.catalogs.repository.bo.DiagnosisBo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiagnosisRepository extends CrudRepository<DiagnosisBo, String> {
    List<DiagnosisBo> findByDisplayStartsWithIgnoreCase(String display);
}
