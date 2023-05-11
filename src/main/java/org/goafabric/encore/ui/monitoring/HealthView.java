package org.goafabric.encore.ui.monitoring;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.web.client.RestTemplate;


@PageTitle("Health")
public class HealthView extends VerticalLayout {
    public HealthView(HealthEndpoint healthEndpoint) {
        //List<HealthIndicator> healthIndicators
        setSizeFull();

        var status = healthEndpoint.health().getStatus().getCode();
        add(new HorizontalLayout(new Text("Application"), status.equals("UP") ? new Icon(VaadinIcon.CHECK) : new Icon(VaadinIcon.WARNING)));
        add(new HorizontalLayout(new Text("Tracing"), checkTracing() ? new Icon(VaadinIcon.CHECK) : new Icon(VaadinIcon.WARNING)));
    }

    private boolean checkTracing() {
        try {
            var restTemplate = new RestTemplate();
            return restTemplate.getForEntity("http://localhost:16686/", Object.class).getStatusCode().value() == 200;
        } catch (Exception e) { return false; }
    }
}
