package org.goafabric.encore.ui.patient.practice;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.catalogs.dto.ChargeItem;
import org.goafabric.encore.catalogs.dto.Diagnosis;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.masterdata.logic.PatientLogic;
import org.goafabric.encore.ui.MainView;
import org.goafabric.encore.ui.patient.practice.tabs.MRCView;
import org.goafabric.encore.ui.patient.practice.tabs.PatientView;

@Route(value = "patient", layout = MainView.class)
@PageTitle("Patient")
public class PatientMainView extends VerticalLayout {

    public PatientMainView(
            PatientLogic patientLogic, CrudLogic<Diagnosis> diagnosisLogic, CrudLogic<ChargeItem> chargeItemLogic) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Patient", new PatientView(patientLogic));
        tabSheet.add("MRC", new MRCView(patientLogic, diagnosisLogic, chargeItemLogic));

        add(tabSheet);
    }
}
