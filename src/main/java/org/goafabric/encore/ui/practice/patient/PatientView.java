package org.goafabric.encore.ui.practice.patient;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.masterdata.persistence.PatientAdapter;

@PageTitle("patient")
public class PatientView extends VerticalLayout {
    private final PatientGrid grid = new PatientGrid();
    private final TextField filterText = new TextField("", "Filter by name ...");
    private final PatientAdapter adapter;

    public PatientView(PatientAdapter adapter) {
        this.adapter = adapter;
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
        grid.setItems(adapter.search(filterText.getValue()));
    }
}
