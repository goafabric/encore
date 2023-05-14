package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.controller.dto.Organization;

import java.util.List;

public interface OrganizationAdapter {
    void create(Organization organization);

    void delete(String id);

    void deleteAll();

    Organization getById(String id);

    List<Organization> search(String name);

}
