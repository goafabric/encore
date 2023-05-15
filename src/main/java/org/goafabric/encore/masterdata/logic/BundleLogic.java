package org.goafabric.encore.masterdata.logic;

import org.goafabric.encore.crossfunctional.DurationLog;
import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class BundleLogic {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final FhirLogic<Patient> patientLogic;

    private final FhirLogic<Practitioner> practitionerLogic;

    public BundleLogic(FhirLogic<Patient> patientLogic, FhirLogic<Practitioner> practitionerLogic) {
        this.patientLogic = patientLogic;
        this.practitionerLogic = practitionerLogic;
    }

    public Bundle getBundle(String id) {

        final Bundle bundle = new Bundle();
        bundle.addEntry(createBundleEntry(
                patientLogic.getById(id), id));
        bundle.addEntry(createBundleEntry(
                practitionerLogic.getById(id), id));

        return bundle;
    }

    private Bundle.BundleEntryComponent createBundleEntry(Object resource, String id) {
        return Bundle.BundleEntryComponent.builder().resource(resource)
                .fullUrl(resource.getClass().getSimpleName() + "/" + id).build();
    }


    public void createBundle(Bundle bundle) {
        log.info("create bundle : {}", bundle.toString() );
    }
}
