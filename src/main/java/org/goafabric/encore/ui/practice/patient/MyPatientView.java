package org.goafabric.encore.ui.practice.patient;

import com.vaadin.flow.component.grid.Grid;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.ui.GridView;

public class MyPatientView extends GridView<Patient> {

    public MyPatientView(FhirLogic<Patient> logic) {
        super(new Grid<>(Patient.class), logic);
    }

    @Override
    protected void addColumns(Grid<Patient> grid) {
        grid.addColumn(p -> p.getName().get(0).getGiven().get(0)).setHeader("firstName");
        grid.addColumn(p -> p.getName().get(0).getFamily()).setHeader("lastName");
        grid.addColumn(p -> p.getAddress().get(0).getCity()).setHeader("city");
        grid.addColumn(p -> p.getAddress().get(0).getLine().get(0)).setHeader("street");
    }
}
