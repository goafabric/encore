package org.goafabric.encore.ui.practice;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.masterdata.logic.OrganizationLogic;
import org.goafabric.encore.masterdata.logic.PatientLogic;
import org.goafabric.encore.masterdata.logic.PractitionerLogic;
import org.goafabric.encore.ui.MainView;

@Route(value = "practice", layout = MainView.class)
@PageTitle("Practice")
public class PracticeView extends VerticalLayout {

    public PracticeView(
            PatientLogic patientLogic, PractitionerLogic practitionerLogic, OrganizationLogic organizationLogic) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Patient", new PatientView(patientLogic));
        tabSheet.add("Practitioner", new PractitionerView(practitionerLogic));
        tabSheet.add("Organization", new OrganizationView(organizationLogic));

        add(tabSheet);
    }
}
