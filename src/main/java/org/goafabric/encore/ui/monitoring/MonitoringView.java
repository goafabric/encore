package org.goafabric.encore.ui.monitoring;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.ui.MainView;
import org.goafabric.encore.ui.monitoring.tabs.FhirView;
import org.goafabric.encore.ui.monitoring.tabs.HealthView;
import org.goafabric.encore.ui.monitoring.tabs.TracingView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.HealthEndpoint;

@Route(value = "monitoring", layout = MainView.class)
@PageTitle("Monitoring")
public class MonitoringView extends VerticalLayout {

    public MonitoringView(HealthEndpoint healthEndpoint,
                          @Value("${spring.cloud.aws.s3.endpoint:}") String s3Endpoint,
                          @Value("${management.zipkin.tracing.endpoint}") String tracingEndpoint) {
        this.setSizeFull();

        tracingEndpoint = tracingEndpoint.replaceAll(":9411/api/v2/spans", ":16686");

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Health", new HealthView(healthEndpoint, s3Endpoint, tracingEndpoint));

        tabSheet.add("FHIR", new FhirView());

        tabSheet.add("Tracing", new TracingView(tracingEndpoint));

        add(tabSheet);
    }
}
