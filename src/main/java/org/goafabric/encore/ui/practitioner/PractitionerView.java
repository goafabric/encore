package org.goafabric.encore.ui.practitioner;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.masterdata.persistence.mock.PractitionerMockAdapter;
import org.goafabric.encore.ui.MainLayout;

@Route(value = "practitioner", layout = MainLayout.class)
@PageTitle("practitioner")
public class PractitionerView extends VerticalLayout {
    private final PractitionerGrid grid;
    private final TextField filterText;
    private final PractitionerMockAdapter adapter;

    public PractitionerView(PractitionerMockAdapter adapter) {
        this.adapter = adapter;

        grid = new PractitionerGrid();
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
