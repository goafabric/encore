package org.goafabric.encore.ui.catalogs;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.catalogs.dto.ChargeItem;
import org.goafabric.encore.catalogs.dto.Diagnosis;
import org.goafabric.encore.catalogs.dto.Insurance;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.ui.MainView;
import org.goafabric.encore.ui.catalogs.tabs.ChargeItemView;
import org.goafabric.encore.ui.catalogs.tabs.DiagnosisView;
import org.goafabric.encore.ui.catalogs.tabs.InsuranceVIew;

@Route(value = "catalogs", layout = MainView.class)
@PageTitle("Catalogs")
public class CatalogView extends VerticalLayout {

    public CatalogView(CrudLogic<Insurance> insuranceLogic, CrudLogic<Diagnosis> diagnosisCatalogLogic, CrudLogic<ChargeItem> chargeItemViewCrudLogic) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Insurance", new InsuranceVIew(insuranceLogic));
        tabSheet.add("Diagnosis", new DiagnosisView(diagnosisCatalogLogic));
        tabSheet.add("Charges", new ChargeItemView(chargeItemViewCrudLogic));

        add(tabSheet);
    }
}
