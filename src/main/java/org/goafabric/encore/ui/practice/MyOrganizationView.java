package org.goafabric.encore.ui.practice;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.ui.GridView;

@PageTitle("organization")
public class MyOrganizationView extends GridView<Organization> {

    public MyOrganizationView(FhirLogic<Organization> logic) {
        super(new Grid<>(Organization.class), logic);
    }

    @Override
    protected void addColumns(Grid<Organization> grid) {
        grid.addColumn(Organization::getName).setHeader("name");
        grid.addColumn(p -> p.getAddress().get(0).getCity()).setHeader("city");
        grid.addColumn(p -> p.getAddress().get(0).getLine().get(0)).setHeader("street");
    }
}
