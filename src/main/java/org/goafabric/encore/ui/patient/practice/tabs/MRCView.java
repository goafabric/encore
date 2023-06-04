package org.goafabric.encore.ui.patient.practice.tabs;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.goafabric.encore.masterdata.logic.PatientLogic;

public class MRCView extends HorizontalLayout {
    private final PatientLogic patientLogic;

    public MRCView(PatientLogic patientLogic) {
        this.patientLogic = patientLogic;
    }
}
