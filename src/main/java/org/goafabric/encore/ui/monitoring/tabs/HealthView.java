package org.goafabric.encore.ui.monitoring.tabs;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.ResourceAccessException;

import java.time.Duration;


@PageTitle("Health")
public class HealthView extends VerticalLayout {
    public HealthView(HealthEndpoint healthEndpoint, String s3Endpoint, String tracingEndpoint) {
        setSizeFull();

        var status = healthEndpoint.health().getStatus().getCode();
        add(new HorizontalLayout(new Text("Application"), status.equals("UP") ? new Icon(VaadinIcon.CHECK) : new Icon(VaadinIcon.WARNING)));
        add(new HorizontalLayout(new Text("Tracing"), checkEndpoint(tracingEndpoint) ? new Icon(VaadinIcon.CHECK) : new Icon(VaadinIcon.WARNING)));
        add(new HorizontalLayout(new Text("S3"), checkEndpoint(s3Endpoint) ? new Icon(VaadinIcon.CHECK) : new Icon(VaadinIcon.WARNING)));
    }

    public static boolean checkEndpoint(String url) {
        try {
            return new RestTemplateBuilder().setConnectTimeout(Duration.ofSeconds(1)).setReadTimeout(Duration.ofSeconds(1)).build()
                    .getForEntity(url, Object.class).getStatusCode().value() == 200;
        } catch (Exception e) { return !(e instanceof ResourceAccessException);}
    }
}
