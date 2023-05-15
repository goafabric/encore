package org.goafabric.encore.ui.files.tabs;

import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;

@PageTitle("Jaeger")
public class S3View extends VerticalLayout {

    public S3View(String s3Endpoint ) {
        setSizeFull();

        IFrame iFrame = new IFrame();
        iFrame.setSrc(s3Endpoint.replaceAll("9100", "9101")); // + "/browser/objects");
        iFrame.setSizeFull();
        this.add(iFrame);
    }
}
