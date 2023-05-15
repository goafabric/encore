package org.goafabric.encore.ui.monitoring.tabs;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;

@PageTitle("FHIR")
public class FhirView extends VerticalLayout {
    public FhirView() {
        setSizeFull();

        this.add(new Text("/fhir/Patient/1"));

        IFrame patient = new IFrame();
        patient.setSrc("/fhir/Patient/1");
        patient.setWidth("1000px");
        patient.setHeight("200px");
        this.add(patient);

        this.add(new Text("/fhir/Practitioner/1"));

        IFrame practitioner = new IFrame();
        practitioner.setSrc("/fhir/Patient/1");
        practitioner.setWidth("1000px");
        practitioner.setHeight("200px");
        this.add(practitioner);
        
        /*
        IFrame iFrame = new IFrame();
        iFrame.setSrc("/swagger-ui/index.html");
        iFrame.setSizeFull();
        this.add(iFrame);
        */

    }
}
