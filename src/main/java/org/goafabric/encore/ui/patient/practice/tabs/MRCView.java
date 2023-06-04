package org.goafabric.encore.ui.patient.practice.tabs;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.CallbackDataProvider;
import org.goafabric.encore.catalogs.dto.ChargeItem;
import org.goafabric.encore.catalogs.dto.Diagnosis;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.masterdata.logic.PatientLogic;

import java.util.ArrayList;

public class MRCView extends VerticalLayout {
    private final PatientLogic patientLogic;
    private final CrudLogic<Diagnosis> diagnosisLogic;
    private final CrudLogic<ChargeItem> chargeItemLogic;

    public MRCView(PatientLogic patientLogic, CrudLogic<Diagnosis> diagnosisLogic, CrudLogic<ChargeItem> chargeItemLogic) {
        this.patientLogic = patientLogic;
        this.diagnosisLogic = diagnosisLogic;
        this.chargeItemLogic = chargeItemLogic;

        setSizeFull();
        addMasterFilter();
        addAddButton();
    }

    private void addMasterFilter() {
        var masterFilter = new ComboBox<>("", "Filter ...");
        masterFilter.setItems((CallbackDataProvider.FetchCallback<String, String>) query -> {
            query.getLimit(); query.getOffset();
            var filter = query.getFilter().get();
            return filter.equals("")
                    ? new ArrayList<String>().stream()
                    : patientLogic.searchLastNames(filter).stream().limit(query.getLimit());
        });

        this.add(masterFilter);
    }

    private void addAddButton() {
        var filterAddButton = new Button("+");

        this.add(filterAddButton);
        filterAddButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addFilterEntry();
            }
        });
    }

    private void addFilterEntry() {
        var typeCombo = new ComboBox<>("", "Diagnosis", "GOÄ");
        var filterCombo = new ComboBox<>("", "Filter ...");
        add(new HorizontalLayout(typeCombo, filterCombo));
        
        typeCombo.addValueChangeListener(event -> setItems(typeCombo, filterCombo));
        typeCombo.setValue("Diagnosis");
    }

    private void setItems(ComboBox<String> typeCombo, ComboBox<String> filterCombo) {
        filterCombo.setItems((CallbackDataProvider.FetchCallback<String, String>) query -> {
            query.getLimit(); query.getOffset();
            var filter = query.getFilter().get();
            if (typeCombo.getValue().equals("Diagnosis")) {
                return diagnosisLogic.search(filter).stream().map(d -> d.getDisplay()).limit(query.getLimit());
            }
            if (typeCombo.getValue().equals("GOÄ")) {
                return chargeItemLogic.search(filter).stream().map(d -> d.getDisplay()).limit(query.getLimit());
            }
            return new ArrayList<String>().stream();
        });
    }

}
