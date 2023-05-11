package org.goafabric.encore.ui.catalogs;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.catalogs.InsuranceCatalogLogic;
import org.goafabric.encore.ui.MainLayout;
import org.goafabric.encore.ui.catalogs.coverage.CoverageView;

@Route(value = "catalogs", layout = MainLayout.class)
@PageTitle("Catalogs")
public class CatalogView extends VerticalLayout {

    public CatalogView(InsuranceCatalogLogic coverageLogic) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Insurance",
                new CoverageView(coverageLogic));

        add(tabSheet);
    }
}
