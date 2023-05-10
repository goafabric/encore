package org.goafabric.encore.masterdata.persistence.mock;

import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.persistence.PatientAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("mock")
@Component
public class PatientMockAdapter implements PatientAdapter {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void create(Patient patient) {
        log.info("creating patient " + patient.toString());
    }

    @Override
    public void delete(String id) {
        log.info("deleting patient" + id);
    }

    public Patient getPatient(String id) {
        return createPatient(id);
    }

    @Override
    public Bundle search(String lastName) {
        Bundle bundle = new Bundle();
        bundle.addEntry(createBundleEntry(createPatient("1"), "1"));
        return bundle;
    }

    private Patient createPatient(String id) {
        return Patient.builder()
                .id(id)
                .name(MockUtil.createName("Homer", "Simpson"))
                .address(MockUtil.createAddress("Evergreen Terrace 742"))
                .telecom(MockUtil.createTelecom("0245-33553"))
                .build();
    }

    private Bundle.BundleEntryComponent createBundleEntry(Object resource, String id) {
        return Bundle.BundleEntryComponent.builder().resource(resource)
                .fullUrl(resource.getClass().getSimpleName() + "/" + id).build();
    }

}
