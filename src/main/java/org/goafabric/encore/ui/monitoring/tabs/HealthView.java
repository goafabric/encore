package org.goafabric.encore.ui.monitoring.tabs;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;


@PageTitle("Health")
public class HealthView extends VerticalLayout {
    public HealthView(HealthEndpoint healthEndpoint, String s3Endpoint) {
        setSizeFull();

        var status = healthEndpoint.health().getStatus().getCode();
        add(new HorizontalLayout(new Text("Application"), status.equals("UP") ? new Icon(VaadinIcon.CHECK) : new Icon(VaadinIcon.WARNING)));
        add(new HorizontalLayout(new Text("Tracing"), checkEndpoint("http://localhost:16686/") ? new Icon(VaadinIcon.CHECK) : new Icon(VaadinIcon.WARNING)));
        add(new HorizontalLayout(new Text("S3"), checkEndpoint(s3Endpoint) ? new Icon(VaadinIcon.CHECK) : new Icon(VaadinIcon.WARNING)));
    }

    private boolean checkEndpoint(String url) {
        try {
            return new RestTemplate().getForEntity(url, Object.class).getStatusCode().value() == 200;
        } catch (Exception e) { return !(e instanceof ResourceAccessException);}
    }
}
