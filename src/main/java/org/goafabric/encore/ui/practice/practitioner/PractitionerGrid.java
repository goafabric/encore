package org.goafabric.encore.ui.practice.practitioner;


import com.vaadin.flow.component.grid.Grid;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;

public class PractitionerGrid extends Grid<Practitioner> {

    public PractitionerGrid() {
        super(Practitioner.class);
        createView();
    }

    private void createView() {
        addClassName("contact-grid");
        setSizeFull();
        setColumns();

        addColumn(p -> p.getName().get(0).getGiven().get(0)).setHeader("firstName");
        addColumn(p -> p.getName().get(0).getFamily()).setHeader("lastName");
        addColumn(p -> p.getAddress().get(0).getCity()).setHeader("city");
        addColumn(p -> p.getAddress().get(0).getLine().get(0)).setHeader("street");

        getColumns().forEach(col -> col.setAutoWidth(true));
    }
}
