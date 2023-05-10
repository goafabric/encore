package org.goafabric.encore.ui.practitioner;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.masterdata.persistence.mock.PractitionerMockAdapter;
import org.goafabric.encore.ui.main.MainLayout;

@Route(value = "practitioner", layout = MainLayout.class)
@PageTitle("practitioner")
public class PractitionerController extends VerticalLayout {
    private final PractitionerGrid practitionerGrid;

    public PractitionerController(PractitionerMockAdapter adapter) {
        practitionerGrid = new PractitionerGrid();

        setSizeFull();
        this.add(new Text("Practitioners ..."));
        this.add(practitionerGrid);

        practitionerGrid.setItems(adapter.searchShortCut(""));
    }
}
