package org.goafabric.encore.security.logic.mock;

import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.security.dto.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Profile("mock")
@Component
public class RolesLogic implements CrudLogic<Role> {
    private List<Role> roles = new ArrayList<>();

    @Override
    public void create(Role userRole) {
        roles.add(userRole);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll() {
        roles.clear();
    }

    @Override
    public Role getById(String id) {
        return null;
    }

    @Override
    public List<Role> search(String search) {
        return roles.stream().filter(role -> role.getRole().toLowerCase().startsWith(search.toLowerCase())).toList();
    }
}
