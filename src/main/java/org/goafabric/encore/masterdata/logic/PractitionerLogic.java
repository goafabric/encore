package org.goafabric.encore.masterdata.logic;

import lombok.experimental.Delegate;
import org.goafabric.encore.crossfunctional.DurationLog;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.persistence.PractitionerAdapter;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class PractitionerLogic implements FhirLogic<Practitioner> {
    @Delegate
    private final PractitionerAdapter practitionerAdapter;

    public PractitionerLogic(PractitionerAdapter practitionerAdapter) {
        this.practitionerAdapter = practitionerAdapter;
    }

}
