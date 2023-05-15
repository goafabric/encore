package org.goafabric.encore.ui.files;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.archive.dto.ObjectEntry;
import org.goafabric.encore.files.ExportLogic;
import org.goafabric.encore.files.ImportLogic;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.ui.MainView;
import org.goafabric.encore.ui.files.tabs.ArchiveView;
import org.goafabric.encore.ui.files.tabs.ImportExportView;

@Route(value = "files", layout = MainView.class)
@PageTitle("Files")
public class FilesView extends VerticalLayout {

    public FilesView(FhirLogic<ObjectEntry> archiveLogic, ImportLogic importLogic, ExportLogic exportLogic) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Archive", new ArchiveView(archiveLogic));
        tabSheet.add("Import & Export", new ImportExportView(importLogic, exportLogic));

        add(tabSheet);
    }
}
