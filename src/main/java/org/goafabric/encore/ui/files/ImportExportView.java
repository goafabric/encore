package org.goafabric.encore.ui.files;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
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

        pathField.setValue("/Users/andreas/Downloads");
        this.add(pathField);

        var importButton = new Button("import");
        var exportButton = new Button("export");
        this.add(new HorizontalLayout(pathField, importButton, exportButton));

        importButton.addClickListener(event -> importFiles(pathField.getValue()));
        exportButton.addClickListener(event -> exportFiles(pathField.getValue()));
    }

    private void importFiles(String value) {
        System.out.println("import ...");
    }

    private void exportFiles(String path) {
        ProgressBar progressBar = createProgressBar();
        try {
            exportLogic.run(path);
            var notification = Notification.show("Export successful");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } catch (Exception e) {
            var notification = Notification.show("Error during export : " + e.getMessage());
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        } finally {
            progressBar.setVisible(false);
        }

    }

    private ProgressBar createProgressBar() {
        var progressBar = new ProgressBar();
        progressBar.setIndeterminate(true);
        //Div progressBarLabel = new Div();
        //progressBarLabel.setText("Exporting data ...");
        add(progressBar);
        return progressBar;
    }

}