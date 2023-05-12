package org.goafabric.encore.ui.catalogs.coverage;


import com.vaadin.flow.component.grid.Grid;
import org.goafabric.encore.catalogs.Insurance;

public class CoverageGrid extends Grid<Insurance> {

    public CoverageGrid() {
        super(Insurance.class);
        createView();
    }

    private void createView() {
        setSizeFull();
        setColumns();

        addColumn(Insurance::getCode).setHeader("ikk");
        addColumn(Insurance::getDisplay).setHeader("description");
        addColumn(Insurance::getReference).setHeader("ref");

        getColumns().forEach(col -> col.setAutoWidth(true));
    }
}
