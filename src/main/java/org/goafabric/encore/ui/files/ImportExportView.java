package org.goafabric.encore.ui.files;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.files.ExportLogic;

@PageTitle("Import & Export")
public class ImportExportView extends VerticalLayout {
    private final TextField pathField = new TextField();
    private final ExportLogic exportLogic;

    public ImportExportView(ExportLogic exportLogic) {
        this.exportLogic = exportLogic;
        createView();
    }

    private void createView() {
        setSizeFull();

        createPathField();

        createButtons();
    }

    private void createPathField() {
        pathField.setValue("/Users/andreas/Downloads");
        this.add(pathField);
    }

    private void createButtons() {
        var importButton = new Button("import");
        var exportButton = new Button("export");
        this.add(new HorizontalLayout(importButton, exportButton));

        importButton.addClickListener(event -> importFiles(pathField.getValue()));
        exportButton.addClickListener(event -> exportFiles(pathField.getValue()));
    }

    private void importFiles(String value) {
        System.out.println("import ...");
    }

    private void exportFiles(String path) {
        try {
            exportLogic.export(path);
            var notification = Notification.show("Export successful");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } catch (Exception e) {
            var notification = Notification.show("Error during export : " + e.getMessage());
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }
    }

}
