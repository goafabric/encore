package org.goafabric.encore.masterdata.repository;

import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization, String> {
    List<Organization> findByNameStartsWithIgnoreCase(String name);
}
