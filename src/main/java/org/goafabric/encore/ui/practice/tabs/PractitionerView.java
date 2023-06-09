package org.goafabric.encore.ui.practice.tabs;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.ui.GridView;

@PageTitle("Practitioner")
public class PractitionerView extends GridView<Practitioner> {

    public PractitionerView(CrudLogic<Practitioner> logic) {
        super(new Grid<>(Practitioner.class), logic);
    }

    @Override
    protected void addColumns(Grid<Practitioner> grid) {
        grid.addColumn(p -> p.getName().get(0).getGiven().get(0)).setHeader("First Name");
        grid.addColumn(p -> p.getName().get(0).getFamily()).setHeader("Last Name");
        grid.addColumn(p -> p.getAddress().get(0).getCity()).setHeader("City");
        grid.addColumn(p -> p.getAddress().get(0).getLine().get(0)).setHeader("Street");
    }
}
