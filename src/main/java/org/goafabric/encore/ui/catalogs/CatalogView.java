package org.goafabric.encore.ui.catalogs;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.catalogs.DiagnosisCatalogLogic;
import org.goafabric.encore.catalogs.InsuranceCatalogLogic;
import org.goafabric.encore.ui.MainLayout;

@Route(value = "catalogs", layout = MainLayout.class)
@PageTitle("Catalogs")
public class CatalogView extends VerticalLayout {

    public CatalogView(InsuranceCatalogLogic coverageLogic, DiagnosisCatalogLogic diagnosisCatalogLogic) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Insurance", new InsuranceVIew(coverageLogic));
        tabSheet.add("Diagnosis", new DiagnosisView(diagnosisCatalogLogic));

        add(tabSheet);
    }
}
