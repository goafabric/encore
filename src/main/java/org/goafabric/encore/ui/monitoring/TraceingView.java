package org.goafabric.encore.ui.monitoring;

import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.ui.main.MainLayout;

@Route(value = "jaeger", layout = MainLayout.class)
@PageTitle("Jaeger")
public class TraceingView extends VerticalLayout {
    public TraceingView() {
        setSizeFull();

        IFrame iFrame = new IFrame();
        iFrame.setSrc("http://localhost:16686/search");
        iFrame.setSizeFull();
        this.add(iFrame);
    }
}
