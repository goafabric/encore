package org.goafabric.encore.catalogs.repository;

import org.goafabric.encore.catalogs.dto.Insurance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InsuranceRepository extends CrudRepository<Insurance, String> {
    List<Insurance> findByDisplayStartsWithIgnoreCase(String display);
}
