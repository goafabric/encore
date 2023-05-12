package org.goafabric.encore.ui.practice;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.ui.GridView;

@PageTitle("Patient")
public class PatientView extends GridView<Patient> {

    public PatientView(FhirLogic<Patient> logic) {
        super(new Grid<>(Patient.class), logic);
    }

    @Override
    protected void addColumns(Grid<Patient> grid) {
        grid.addColumn(p -> p.getName().get(0).getGiven().get(0)).setHeader("First Name");
        grid.addColumn(p -> p.getName().get(0).getFamily()).setHeader("Last Name");
        grid.addColumn(p -> p.getAddress().get(0).getCity()).setHeader("City");
        grid.addColumn(p -> p.getAddress().get(0).getLine().get(0)).setHeader("Street");
    }
}
