package org.goafabric.encore.ui.catalogs;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.catalogs.logic.DiagnosisCatalogLogic;
import org.goafabric.encore.catalogs.logic.InsuranceCatalogLogic;
import org.goafabric.encore.ui.MainView;
import org.goafabric.encore.ui.catalogs.tabs.DiagnosisView;
import org.goafabric.encore.ui.catalogs.tabs.InsuranceVIew;

@Route(value = "catalogs", layout = MainView.class)
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
