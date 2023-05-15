package org.goafabric.encore.ui.files.tabs;

import com.vaadin.flow.component.grid.Grid;
import org.goafabric.encore.archive.dto.ObjectEntry;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.ui.GridView;

public class ArchiveView extends GridView<ObjectEntry> {
    public ArchiveView(FhirLogic<ObjectEntry> logic) {
        super(new Grid<>(ObjectEntry.class), logic);
    }

    @Override
    protected void addColumns(Grid<ObjectEntry> grid) {
        grid.addColumn(o -> o.getObjectName()).setHeader("Name");
        grid.addColumn(o -> o.getContentType()).setHeader("Type");
        grid.addColumn(o -> o.getObjectSize()).setHeader("Size");
    }
}
