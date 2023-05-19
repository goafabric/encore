package org.goafabric.encore.ui.practice.tabs;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.ui.GridView;

@PageTitle("Organization")
public class OrganizationView extends GridView<Organization> {

    public OrganizationView(CrudLogic<Organization> logic) {
        super(new Grid<>(Organization.class), logic);
    }

    @Override
    protected void addColumns(Grid<Organization> grid) {
        grid.addColumn(Organization::getName).setHeader("name");
        grid.addColumn(p -> p.getAddress().get(0).getCity()).setHeader("city");
        grid.addColumn(p -> p.getAddress().get(0).getLine().get(0)).setHeader("street");
    }
}
