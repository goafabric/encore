package org.goafabric.encore.ui.practice.tabs;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.security.dto.Role;
import org.goafabric.encore.ui.GridView;

@PageTitle("UserRole")
public class RolesView extends GridView<Role> {

    public RolesView(FhirLogic<Role> logic) {
        super(new Grid<>(Role.class), logic);
    }

    @Override
    protected void addColumns(Grid<Role> grid) {
        grid.addColumn(Role::getRole).setHeader("Role");
    }
}
