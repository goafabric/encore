package org.goafabric.encore.ui.patient.practice.tabs;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.CallbackDataProvider;
import org.goafabric.encore.catalogs.dto.Diagnosis;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.masterdata.logic.PatientLogic;

import java.util.ArrayList;

public class MRCView extends VerticalLayout {
    private final PatientLogic patientLogic;
    private final CrudLogic<Diagnosis> diagnosisLogic;

    public MRCView(PatientLogic patientLogic, CrudLogic<Diagnosis> diagnosisLogic) {
        this.patientLogic = patientLogic;
        this.diagnosisLogic = diagnosisLogic;

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
        var typeCombo = new ComboBox<>("", "");
        typeCombo.setItems("Diagnosis");
        typeCombo.setValue("Diagnosis");

        var filterCombo = new ComboBox<>("", "Filter ...");

        add(new HorizontalLayout(typeCombo, filterCombo));
        filterCombo.setItems((CallbackDataProvider.FetchCallback<String, String>) query -> {
            query.getLimit(); query.getOffset();
            var filter = query.getFilter().get();

            return filter.equals("")
                ? new ArrayList<String>().stream()
                : diagnosisLogic.search(filter).stream().map(d -> d.getDisplay()).limit(query.getLimit());
        });
    }

}
