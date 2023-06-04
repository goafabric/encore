package org.goafabric.encore.ui.patient.practice.tabs;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.CallbackDataProvider;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.logic.PatientLogic;

import java.util.ArrayList;
import java.util.List;

public class MRCView extends VerticalLayout {
    private final PatientLogic patientLogic;

    public MRCView(PatientLogic patientLogic) {
        this.patientLogic = patientLogic;

        setSizeFull();
        addMasterFilter();
        addAddButton();
    }

    private void addMasterFilter() {
        var masterFilter = new ComboBox<>("", "Filter ...");
        masterFilter.setItems((CallbackDataProvider.FetchCallback<String, String>) query -> {
            query.getOffset();
            var filter = query.getFilter().get();
            return patientLogic.searchLastNames(filter).stream().limit(query.getLimit());
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
            return findByLastName(filter).stream().limit(query.getLimit()).map(p -> p.getName().get(0).getFamily());
        });

    }

    private List<Patient> findByLastName(String filter) {
        long start = System.currentTimeMillis();
        var  items = filter.equals("") ? new ArrayList<Patient>() : patientLogic.search(filter);
        long end = System.currentTimeMillis();
        Notification.show("Search took : "  +  (end - start) + " ms");
        return items;
    }

}
