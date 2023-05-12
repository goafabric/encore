package org.goafabric.encore.ui.practice;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.masterdata.logic.PatientLogic;
import org.goafabric.encore.masterdata.persistence.OrganizationAdapter;
import org.goafabric.encore.masterdata.persistence.PractitionerAdapter;
import org.goafabric.encore.ui.MainLayout;
import org.goafabric.encore.ui.practice.organization.OrganizationView;
import org.goafabric.encore.ui.practice.patient.MyPatientView;
import org.goafabric.encore.ui.practice.practitioner.PractitionerView;

@Route(value = "practice", layout = MainLayout.class)
@PageTitle("Practice")
public class PracticeView extends VerticalLayout {

    public PracticeView(
            PatientLogic patientLogic, PractitionerAdapter practitionerAdapter, OrganizationAdapter organizationAdapter) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Patient",
                new MyPatientView(patientLogic));

        tabSheet.add("Practitioner",
                new PractitionerView(practitionerAdapter));

        tabSheet.add("Organization",
                new OrganizationView(organizationAdapter));

        add(tabSheet);
    }
}
