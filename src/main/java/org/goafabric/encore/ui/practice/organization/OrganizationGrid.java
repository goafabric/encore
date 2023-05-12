package org.goafabric.encore.ui.practice.organization;


import com.vaadin.flow.component.grid.Grid;
import org.goafabric.encore.masterdata.controller.dto.Organization;

public class OrganizationGrid extends Grid<Organization> {

    public OrganizationGrid() {
        super(Organization.class);
        createView();
    }

    private void createView() {
        //addClassName("contact-grid");
        setSizeFull();
        setColumns();

        addColumn(p -> p.getName()).setHeader("name");
        addColumn(p -> p.getAddress().get(0).getCity()).setHeader("city");
        addColumn(p -> p.getAddress().get(0).getLine().get(0)).setHeader("street");

        getColumns().forEach(col -> col.setAutoWidth(true));
    }
}
