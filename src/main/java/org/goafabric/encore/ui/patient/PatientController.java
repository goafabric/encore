package org.goafabric.encore.ui.patient;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.ui.main.MainLayout;

@Route(value = "patient", layout = MainLayout.class)
@PageTitle("patient")
public class PatientController extends VerticalLayout {
    public PatientController() {
        setSizeFull();
        this.add(new Text("Patients ..."));
    }
}
