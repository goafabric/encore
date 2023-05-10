package org.goafabric.encore.masterdata.persistence.mock;

import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.persistence.PractitionerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Profile("mock")
@Component
public class PractitionerMockAdapter implements PractitionerAdapter {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final List<Practitioner> practitioners = new ArrayList<>();

    public PractitionerMockAdapter() {
        practitioners.add(createPractitioner("1"));
    }

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


    @Override
    public Bundle search(String lastName) {
        var bundle = new Bundle<Practitioner>();

        practitioners.stream().filter(patient ->
                        patient.getName().get(0).getFamily().toLowerCase().startsWith(lastName.toLowerCase()))
                .forEach(p -> bundle.addEntry(createBundleEntry(p, p.getId())));

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
