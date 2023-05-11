package org.goafabric.encore.ui.monitoring;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.ui.main.MainLayout;

@Route(value = "monitoring", layout = MainLayout.class)
@PageTitle("Monitoring")
public class MonitoringView extends VerticalLayout {

    public MonitoringView() {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("FHIR",
                new FhirView());

        tabSheet.add("Traceing",
                new TracingView());

        add(tabSheet);
    }
}
