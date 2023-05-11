package org.goafabric.encore.ui.practice.practitioner;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.masterdata.persistence.PractitionerAdapter;

@PageTitle("practitioner")
public class PractitionerView extends VerticalLayout {
    private final PractitionerGrid grid = new PractitionerGrid();
    private final TextField filterText = new TextField("", "Filter by name ...");
    private final PractitionerAdapter adapter;

    public PractitionerView(PractitionerAdapter adapter) {
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
