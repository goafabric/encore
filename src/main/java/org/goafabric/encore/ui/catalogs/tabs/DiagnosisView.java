package org.goafabric.encore.ui.catalogs.tabs;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.catalogs.dto.Diagnosis;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.ui.GridView;

@PageTitle("Diagnosis")
public class DiagnosisView extends GridView<Diagnosis> {

    public DiagnosisView(FhirLogic<Diagnosis> logic) {
        super(new Grid<>(Diagnosis.class), logic);
    }

    @Override
    protected void addColumns(Grid<Diagnosis> grid) {
        grid.addColumn(Diagnosis::getCode).setHeader("ikk");
        grid.addColumn(Diagnosis::getDisplay).setHeader("description");
        grid.addColumn(Diagnosis::getReference).setHeader("ref");
    }
}
