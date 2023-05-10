package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.controller.dto.Organization;

public interface OrganizationAdapter {
    void create(Organization organization);

    void delete(String id);

    Organization getById(String id);

    Bundle search(String name);

}
