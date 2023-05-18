package org.goafabric.encore.catalogs.repository;

import org.goafabric.encore.catalogs.dto.Diagnosis;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiagnosisRepository extends CrudRepository<Diagnosis, String> {
    List<Diagnosis> findByDisplayStartsWithIgnoreCase(String display);
}
