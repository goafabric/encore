package org.goafabric.encore.ui.practice;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.masterdata.persistence.PatientAdapter;
import org.goafabric.encore.masterdata.persistence.PractitionerAdapter;
import org.goafabric.encore.ui.main.MainLayout;
import org.goafabric.encore.ui.practice.patient.PatientView;
import org.goafabric.encore.ui.practice.practitioner.PractitionerView;

@Route(value = "practice", layout = MainLayout.class)
@PageTitle("Practice")
public class PracticeView extends VerticalLayout {

    public PracticeView(PatientAdapter patientAdapter, PractitionerAdapter practitionerAdapter) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Patient",
                new PatientView(patientAdapter));

        tabSheet.add("Practitioner",
                new PractitionerView(practitionerAdapter));

        add(tabSheet);
    }
}
