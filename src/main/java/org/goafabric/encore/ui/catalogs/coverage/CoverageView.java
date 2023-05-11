package org.goafabric.encore.ui.catalogs.coverage;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.catalogs.InsuranceCatalogLogic;

//@Route(value = "coverage", layout = MainLayout.class)
@PageTitle("Coverage")
public class CoverageView extends VerticalLayout {
    private final CoverageGrid grid = new CoverageGrid();
    private final TextField filterText = new TextField("", "Filter by name ...");
    private final InsuranceCatalogLogic coverageLogic;

    public CoverageView(InsuranceCatalogLogic coverageLogic) {
        this.coverageLogic = coverageLogic;
        createView();
    }

    private void createView() {
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        setSizeFull();
        this.add(filterText);
        this.add(grid);
        updateList();
    }


    private void updateList() {
        grid.setItems(coverageLogic.search(filterText.getValue()));
    }
}
