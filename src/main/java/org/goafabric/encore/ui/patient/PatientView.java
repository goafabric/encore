package org.goafabric.encore.ui.patient;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.masterdata.persistence.mock.PatientMockAdapter;
import org.goafabric.encore.ui.MainLayout;

@Route(value = "patient", layout = MainLayout.class)
@PageTitle("patient")
public class PatientView extends VerticalLayout {
    private final PatientGrid grid;
    private final TextField filterText;
    private final PatientMockAdapter adapter;

    public PatientView(PatientMockAdapter adapter) {
        this.adapter = adapter;

        grid = new PatientGrid();
        filterText = new TextField("", "Filter by name ...");

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
        grid.setItems(adapter.searchShortCut(filterText.getValue()));
    }
}
