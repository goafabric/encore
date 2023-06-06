package org.goafabric.encore.ui.catalogs.tabs;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.PageTitle;
import org.goafabric.encore.catalogs.dto.ChargeItem;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.ui.GridView;

@PageTitle("ChargeItem")
public class ChargeItemView extends GridView<ChargeItem> {

    public ChargeItemView(CrudLogic<ChargeItem> logic) {
        super(new Grid<>(ChargeItem.class), logic);
    }

    @Override
    protected void addColumns(Grid<ChargeItem> grid) {
        grid.addColumn(ChargeItem::getCode).setHeader("code");
        grid.addColumn(ChargeItem::getDisplay).setHeader("description");
        grid.addColumn(ChargeItem::getPrice).setHeader("price");
    }
}
