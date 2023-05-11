package org.goafabric.encore.ui.catalogs.diagnosis;


import com.vaadin.flow.component.grid.Grid;
import org.goafabric.encore.catalogs.Diagnosis;

public class DiagnosisGrid extends Grid<Diagnosis> {

    public DiagnosisGrid() {
        super(Diagnosis.class);
        createView();
    }

    private void createView() {
        setSizeFull();
        setColumns();

        addColumn(Diagnosis::getCode).setHeader("code");
        addColumn(Diagnosis::getDisplay).setHeader("description");
        addColumn(Diagnosis::getReference).setHeader("ref");

        getColumns().forEach(col -> col.setAutoWidth(true));
    }
}
