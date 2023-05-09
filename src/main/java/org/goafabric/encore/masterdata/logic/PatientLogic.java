package org.goafabric.encore.masterdata.logic;

import lombok.experimental.Delegate;
import org.goafabric.encore.crossfunctional.DurationLog;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.persistence.PatientAdapter;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class PatientLogic {
    @Delegate
    private final PatientAdapter patientAdapter;

    public PatientLogic(PatientAdapter patientAdapter) {
        this.patientAdapter = patientAdapter;
    }

    public void createPatient(Patient patient) {
    }
}
