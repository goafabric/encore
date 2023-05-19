package org.goafabric.encore.masterdata.logic.mock;

import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Profile({"mock"})
@Component
public class OrganizationLogic implements CrudLogic<Organization> {
    private final List<Organization> organizations = new ArrayList<>();

    public OrganizationLogic() {
    }

    @Override
    public void create(Organization organization) {
        organizations.add(organization);
    }

    @Override
    public void delete(String id) {
        //throw new IllegalStateException("NYI");
    }

    @Override
    public void deleteAll() {
        organizations.clear();
    }

    public Organization getById(String id) {
        return organizations.get(0);
    }

    public List<Organization> search(String name) {
        return organizations.stream().filter(organization ->
                organization.getName().toLowerCase().startsWith(name.toLowerCase())).toList();
    }

}
