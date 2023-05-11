package org.goafabric.encore.masterdata.persistence.mock;

import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.persistence.OrganizationAdapter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Profile("mock")
@Component
public class OrganizationMockAdapter implements OrganizationAdapter {
    private final List<Organization> organizations = new ArrayList<>();

    public OrganizationMockAdapter() {
        organizations.add(createOrganization());
    }

    @Override
    public void create(Organization organization) {
    }

    @Override
    public void delete(String id) {

    }

    public List<Organization> search(String name) {
        return organizations.stream().filter(organization ->
                                organization.getName().toLowerCase().startsWith(name.toLowerCase())).toList();
    }

    public Organization getById(String id) {
        return organizations.get(0);
    }

    private static Organization createOrganization() {
        return Organization.builder()
                .id(UUID.randomUUID().toString())
                .name("Practice Dr Hibbert")
                .address(MockUtil.createAddress("Commonstreet 345"))
                .build();
    }

}
