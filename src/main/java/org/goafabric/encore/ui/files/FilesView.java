package org.goafabric.encore.ui.files;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.files.ExportLogic;
import org.goafabric.encore.ui.MainView;

@Route(value = "files", layout = MainView.class)
@PageTitle("Files")
public class FilesView extends VerticalLayout {

    public FilesView(ExportLogic exportLogic) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Import & Export", new ImportExportView(exportLogic));
        /*
        tabSheet.add("Patient", new PatientView(patientLogic));
        tabSheet.add("Practitioner", new PractitionerView(practitionerLogic));
        tabSheet.add("Organization", new OrganizationView(organizationLogic));

         */

        add(tabSheet);
    }
}
