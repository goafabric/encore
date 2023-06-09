package org.goafabric.encore.ui.catalogs.tabs;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.catalogs.dto.Insurance;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.ui.GridView;

@PageTitle("Insurance")
public class InsuranceVIew extends GridView<Insurance> {

    public InsuranceVIew(CrudLogic<Insurance> logic) {
        super(new Grid<>(Insurance.class), logic);
    }

    @Override
    protected void addColumns(Grid<Insurance> grid) {
        grid.addColumn(Insurance::getCode).setHeader("ikk");
        grid.addColumn(Insurance::getDisplay).setHeader("description");
        grid.addColumn(Insurance::getReference).setHeader("ref");
    }
}
