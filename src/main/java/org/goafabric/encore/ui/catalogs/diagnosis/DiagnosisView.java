package org.goafabric.encore.ui.catalogs.diagnosis;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.catalogs.DiagnosisCatalogLogic;

//@Route(value = "coverage", layout = MainLayout.class)
@PageTitle("Diagnosis")
public class DiagnosisView extends VerticalLayout {
    private final DiagnosisGrid grid = new DiagnosisGrid();
    private final TextField filterText = new TextField("", "Filter by name ...");
    private final DiagnosisCatalogLogic catalogLogic;

    public DiagnosisView(DiagnosisCatalogLogic catalogLogic) {
        this.catalogLogic = catalogLogic;
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
        grid.setItems(catalogLogic.search(filterText.getValue()));
    }
}
