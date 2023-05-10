package org.goafabric.encore.masterdata.persistence.mock;

import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.persistence.OrganizationAdapter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Profile("mock")
@Component
public class OrganizationMockAdapter implements OrganizationAdapter {
    @Override
    public void create(Organization organization) {

    }

    @Override
    public void delete(String id) {

    }

    public Bundle search(String lastName) {
        Bundle bundle = new Bundle<Organization>();
        bundle.addEntry(createBundleEntry(createOrganization(), "1"));
        return bundle;
    }


    public Organization getById(String id) {
        return createOrganization();
    }

    private static Organization createOrganization() {
        return Organization.builder()
                .id(UUID.randomUUID().toString())
                .name("Krust Burger")
                .address(MockUtil.createAddress("Clownstreet 452"))
                .build();
    }

    private Bundle.BundleEntryComponent createBundleEntry(Object resource, String id) {
        return Bundle.BundleEntryComponent.builder().resource(resource)
                .fullUrl(resource.getClass().getSimpleName() + "/" + id).build();
    }

}
