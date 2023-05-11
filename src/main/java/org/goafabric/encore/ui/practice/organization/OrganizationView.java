package org.goafabric.encore.ui.practice.organization;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.masterdata.persistence.OrganizationAdapter;

@PageTitle("patient")
public class OrganizationView extends VerticalLayout {
    private final OrganizationGrid grid = new OrganizationGrid();
    private final TextField filterText = new TextField("", "Filter by name ...");
    private final OrganizationAdapter adapter;

    public OrganizationView(OrganizationAdapter adapter) {
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
