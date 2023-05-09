package org.goafabric.encore.masterdata.persistence.mock;

import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.persistence.OrganizationAdapter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("mock")
@Component
public class OrganizationMockAdapter implements OrganizationAdapter {
    @Override
    public void create(Organization organization) {

    }

    @Override
    public void delete(String id) {

    }

    public Organization getById(String id) {
        return Organization.builder()
                .id(id)
                .name("Krust Burger")
                .address(MockUtil.createAddress("Clownstreet 452"))
                .build();
    }
}
