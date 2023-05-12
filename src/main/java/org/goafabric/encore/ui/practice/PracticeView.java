package org.goafabric.encore.ui.practice;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.masterdata.logic.OrganizationLogic;
import org.goafabric.encore.masterdata.logic.PatientLogic;
import org.goafabric.encore.masterdata.logic.PractitionerLogic;
import org.goafabric.encore.ui.MainLayout;

@Route(value = "practice", layout = MainLayout.class)
@PageTitle("Practice")
public class PracticeView extends VerticalLayout {

    public PracticeView(
            PatientLogic patientLogic, PractitionerLogic practitionerAdapter, OrganizationLogic organizationAdapter) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Patient", new PatientView(patientLogic));

        tabSheet.add("Practitioner", new PractitionerView(practitionerAdapter));

        tabSheet.add("Organization", new OrganizationView(organizationAdapter));

        add(tabSheet);
    }
}
