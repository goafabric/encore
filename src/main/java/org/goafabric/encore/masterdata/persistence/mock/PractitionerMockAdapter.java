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
import java.util.UUID;

@Profile("mock")
@Component
public class PractitionerMockAdapter implements PractitionerAdapter {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final List<Practitioner> practitioners = new ArrayList<>();

    public PractitionerMockAdapter() {
        practitioners.add(createPractitioner("Dr Julius", "Hibbert", "Commonstreet 345", "555-520"));
        practitioners.add(createPractitioner("Dr Marvin", "Monroe", "Psychestreet 104", "555-525"));
        practitioners.add(createPractitioner("Dr Nick", "Riveria", "Nickstreet 221", "555-501"));
    }

    @Override
    public void create(Practitioner practitioner) {
        log.info("creating practitioner " + practitioner.toString());
        practitioners.add(practitioner);
    }

    @Override
    public void delete(String id) {
        log.info("deleting practitioner " + id);
    }

    @Override
    public Practitioner getById(String id) {
        return practitioners.get(0);
    }


    @Override
    public List<Practitioner> search(String lastName) {
        return practitioners.stream().filter(patient ->
                        patient.getName().get(0).getFamily().toLowerCase().startsWith(lastName.toLowerCase())).toList();
    }

    private Bundle<Practitioner> convertToBundle(List<Practitioner> lst) {
        var bundle = new Bundle<Practitioner>();
        lst.forEach(p -> bundle.addEntry(createBundleEntry(p, p.getId())));
        return bundle;
    }


    private Practitioner createPractitioner(String given, String family, String street, String phone) {
        return Practitioner.builder()
                .id(UUID.randomUUID().toString())
                .name(MockUtil.createName(given, family))
                .address(MockUtil.createAddress(street))
                .telecom(MockUtil.createTelecom(phone))
                .build();
    }

    private Bundle.BundleEntryComponent createBundleEntry(Object resource, String id) {
        return Bundle.BundleEntryComponent.builder().resource(resource)
                .fullUrl(resource.getClass().getSimpleName() + "/" + id).build();
    }
}
