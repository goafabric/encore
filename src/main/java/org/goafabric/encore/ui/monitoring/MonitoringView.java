package org.goafabric.encore.ui.monitoring;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.ui.MainView;
import org.springframework.boot.actuate.health.HealthEndpoint;

@Route(value = "monitoring", layout = MainView.class)
@PageTitle("Monitoring")
public class MonitoringView extends VerticalLayout {

    public MonitoringView(HealthEndpoint healthEndpoint) {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Health", new HealthView(healthEndpoint));

        tabSheet.add("FHIR", new FhirView());

        tabSheet.add("Tracing", new TracingView());

        add(tabSheet);
    }
}
