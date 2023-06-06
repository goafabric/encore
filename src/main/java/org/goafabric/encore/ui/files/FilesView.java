package org.goafabric.encore.ui.files;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.importexport.ExportLogic;
import org.goafabric.encore.importexport.ImportLogic;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.objectstorage.dto.ObjectEntry;
import org.goafabric.encore.ui.MainView;
import org.goafabric.encore.ui.files.tabs.ArchiveView;
import org.goafabric.encore.ui.files.tabs.ImportExportView;
import org.springframework.beans.factory.annotation.Value;

@Route(value = "files", layout = MainView.class)
@PageTitle("Files")
public class FilesView extends VerticalLayout {

    public FilesView(@Value("${spring.cloud.aws.s3.enabled:false}") Boolean s3Enabled,
                     @Value("${spring.cloud.aws.s3.endpoint:}") String s3Endpoint,
                     CrudLogic<ObjectEntry> objectStorageLogic, ImportLogic importLogic, ExportLogic exportLogic) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Archive", new ArchiveView(objectStorageLogic));
        tabSheet.add("Import & Export", new ImportExportView(importLogic, exportLogic));

        add(tabSheet);
    }
}
