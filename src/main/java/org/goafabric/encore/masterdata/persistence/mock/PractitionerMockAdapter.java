package org.goafabric.encore.masterdata.persistence.mock;

import org.goafabric.encore.masterdata.controller.dto.*;
import org.goafabric.encore.masterdata.persistence.PractitionerAdapter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Profile("mock")
@Component
public class PractitionerMockAdapter implements PractitionerAdapter {
    @Override
    public Practitioner getPractitioner(String id) {
        return Practitioner.builder()
                .id(id)
                .name(Collections.singletonList(createName()))
                .address(Collections.singletonList(createAddress()))
                .telecom(Collections.singletonList(createTelecom()))
                .build();
    }

    private HumanName createName() {
        //StringType family = new StringType("Burns").addExtension(Extension.builder().url("http://fhir.de/StructureDefinition/humanname-namenszusatz/0.2").valueString("the 3rd").build());
        return HumanName.builder()
                .given(List.of("Monty"))
                .family("Burns")
                .build();
    }

    private Address createAddress() {
        return Address.builder()
                .id("42")
                .city("Springfield")
                .postalCode("78313")
                .country("US")
                .line(List.of("Evergreen Terrace 742"))
                .use(AdressUse.HOME.getValue())
                .build();
    }

    public static Telecom createTelecom() {
        return Telecom.builder()
                .id("45")
                .system(TelecomSystem.PHONE.getValue())
                .use(AdressUse.HOME.getValue())
                .value("0245-33553")
                .build();
    }
}
