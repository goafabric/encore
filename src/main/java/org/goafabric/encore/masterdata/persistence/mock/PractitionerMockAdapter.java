package org.goafabric.encore.masterdata.persistence.mock;

import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.persistence.PractitionerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("mock")
@Component
public class PractitionerMockAdapter implements PractitionerAdapter {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void create(Practitioner practitioner) {
        log.info("creating practitioner " + practitioner.toString());
    }

    @Override
    public void delete(String id) {
        log.info("deleting practitioner " + id);
    }

    @Override
    public Practitioner getById(String id) {
        return createPractitioner(id);
    }

    public Bundle search(String lastName) {
        Bundle bundle = new Bundle<Practitioner>();
        bundle.addEntry(createBundleEntry(createPractitioner("1"), "1"));
        return bundle;
    }


    private static Practitioner createPractitioner(String id) {
        return Practitioner.builder()
                .id(id)
                .name(MockUtil.createName("Monty", "Burns"))
                .address(MockUtil.createAddress("Evergreen Terrace 742"))
                .telecom(MockUtil.createTelecom("0245-33553"))
                .build();
    }

    private Bundle.BundleEntryComponent createBundleEntry(Object resource, String id) {
        return Bundle.BundleEntryComponent.builder().resource(resource)
                .fullUrl(resource.getClass().getSimpleName() + "/" + id).build();
    }
}
