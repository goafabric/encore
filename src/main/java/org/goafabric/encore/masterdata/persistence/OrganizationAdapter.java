package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.controller.dto.Organization;

public interface OrganizationAdapter {
    Organization getOrganization(String id);
}
