package org.goafabric.encore.ui.practice;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.security.dto.Role;
import org.goafabric.encore.ui.MainView;
import org.goafabric.encore.ui.practice.tabs.OrganizationView;
import org.goafabric.encore.ui.practice.tabs.PractitionerView;
import org.goafabric.encore.ui.practice.tabs.RolesView;

@Route(value = "practice", layout = MainView.class)
@PageTitle("Practice")
public class PracticeView extends VerticalLayout {

    public PracticeView(
            FhirLogic<Patient> patientLogic, FhirLogic<Practitioner> practitionerLogic, FhirLogic<Organization> organizationLogic, FhirLogic<Role> rolesLogic) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Practitioner", new PractitionerView(practitionerLogic));
        tabSheet.add("Organization", new OrganizationView(organizationLogic));
        tabSheet.add("Roles", new RolesView(rolesLogic));

        add(tabSheet);
    }
}
