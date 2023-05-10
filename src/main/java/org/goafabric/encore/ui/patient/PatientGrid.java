package org.goafabric.encore.ui.patient;


import com.vaadin.flow.component.grid.Grid;
import org.goafabric.encore.masterdata.controller.dto.Patient;

public class PatientGrid extends Grid<Patient> {

    public PatientGrid() {
        super(Patient.class);
        createView();
    }

    private void createView() {
        addClassName("contact-grid");
        setSizeFull();
        setColumns("firstName", "lastName", "address.street", "address.city");

        addColumn(p -> p.getName().get(0).getGiven()).setHeader("firstName");

        //addColumn(p -> p.getStatus().getName()).setHeader("Status");
        getColumns().forEach(col -> col.setAutoWidth(true));
    }
}
