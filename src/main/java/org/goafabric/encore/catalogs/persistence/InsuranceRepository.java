package org.goafabric.encore.catalogs.persistence;

import org.goafabric.encore.catalogs.persistence.bo.InsuranceBo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InsuranceRepository extends CrudRepository<InsuranceBo, String> {
    List<InsuranceBo> findByDisplayStartsWithIgnoreCase(String display);
}
