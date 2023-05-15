package org.goafabric.encore.ui.monitoring.tabs;

import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;

@PageTitle("Jaeger")
public class TracingView extends VerticalLayout {
    public TracingView() {
        setSizeFull();

        IFrame iFrame = new IFrame();
        iFrame.setSrc("http://localhost:16686/search");
        iFrame.setSizeFull();
        this.add(iFrame);
    }
}
