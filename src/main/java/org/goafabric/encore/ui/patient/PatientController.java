package org.goafabric.encore.ui.patient;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.masterdata.persistence.mock.PatientMockAdapter;
import org.goafabric.encore.ui.main.MainLayout;

@Route(value = "patient", layout = MainLayout.class)
@PageTitle("patient")
public class PatientController extends VerticalLayout {
    private final PatientGrid patientGrid;

    public PatientController(PatientMockAdapter adapter) {
        patientGrid = new PatientGrid();
        setSizeFull();
        this.add(new Text("Patients ..."));
        this.add(patientGrid);


        patientGrid.setItems(adapter.searchShortCut(""));

    }
}
