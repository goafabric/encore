package org.goafabric.encore.ui.monitoring;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.ui.MainView;
import org.goafabric.encore.ui.monitoring.tabs.HealthView;
import org.goafabric.encore.ui.monitoring.tabs.S3View;
import org.goafabric.encore.ui.monitoring.tabs.TracingView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.HealthEndpoint;

@Route(value = "monitoring", layout = MainView.class)
@PageTitle("Monitoring")
public class MonitoringView extends VerticalLayout {

    public MonitoringView(HealthEndpoint healthEndpoint,
                          @Value("${spring.cloud.aws.s3.endpoint:}") String s3Endpoint,
                          @Value("${management.zipkin.tracing.endpoint}") String tracingEndpoint,
                          @Value("${monitoring.view.tracing.url}") String monitoringViewTracingUrl,
                          @Value("${monitoring.view.loki.url}") String monitoringViewLokiUrl,
                          @Value("${monitoring.view.s3.url}") String monitoringViewS3Url
                          ) {
        this.setSizeFull();


        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Health", new HealthView(healthEndpoint, s3Endpoint
                , tracingEndpoint.replaceAll(":9411/api/v2/spans", ":16686")));

        //tabSheet.add("FHIR", new FhirView());

        tabSheet.add("Tracing", new TracingView(monitoringViewTracingUrl));
        tabSheet.add("Loki", new TracingView(monitoringViewLokiUrl));
        tabSheet.add("S3", new S3View(monitoringViewS3Url));

        add(tabSheet);
    }
}
