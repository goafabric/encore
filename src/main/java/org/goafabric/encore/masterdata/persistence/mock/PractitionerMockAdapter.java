package org.goafabric.encore.masterdata.persistence.mock;

import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.persistence.PractitionerAdapter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("mock")
@Component
public class PractitionerMockAdapter implements PractitionerAdapter {
    @Override
    public void create(Practitioner practitioner) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Practitioner getById(String id) {
        return Practitioner.builder()
                .id(id)
                .name(MockUtil.createName("Monty", "Burns"))
                .address(MockUtil.createAddress("Evergreen Terrace 742"))
                .telecom(MockUtil.createTelecom("0245-33553"))
                .build();
    }
}
