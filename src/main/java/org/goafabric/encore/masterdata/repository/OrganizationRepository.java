package org.goafabric.encore.masterdata.repository;

import org.goafabric.encore.masterdata.repository.bo.OrganizationBo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<OrganizationBo, String> {
    List<OrganizationBo> findByNameStartsWithIgnoreCase(String name);
}
