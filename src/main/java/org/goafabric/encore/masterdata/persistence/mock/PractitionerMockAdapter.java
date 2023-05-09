package org.goafabric.encore.masterdata.persistence.mock;

import org.goafabric.encore.masterdata.persistence.PractitionerAdapter;
import org.goafabric.encore.masterdata.controller.dto.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.util.Arrays.asList;

@Profile("mock")
@Component
public class PractitionerMockAdapter implements PractitionerAdapter {
    @Override
    public Practitioner getPractitioner(String id) {
        return Practitioner.builder()
                .id(id)
                .name(Arrays.asList(createName()))
                .address(Arrays.asList(createAddress()))
                .telecom(Arrays.asList(createTelecom()))
                .build();
    }

    private Patient createPatient(String id) {
        return Patient.builder()
                .id(id)
                .name(Arrays.asList(createName()))
                .address(Arrays.asList(createAddress()))
                .telecom(Arrays.asList(createTelecom()))
                .build();
    }


    private HumanName createName() {
        //StringType family = new StringType("Burns").addExtension(Extension.builder().url("http://fhir.de/StructureDefinition/humanname-namenszusatz/0.2").valueString("the 3rd").build());

        var humanName = HumanName.builder()
                .given(Arrays.asList("Monty"))
                .family("Burns")
                .build();

        return humanName;
    }

    private Address createAddress() {
        return Address.builder()
                .id("42")
                .city("Springfield")
                .postalCode("78313")
                .country("US")
                .line(asList("Evergreen Terrace 742"))
                .use("home")
                .build();
    }

    public static Telecom createTelecom() {
        return Telecom.builder()
                .id("45")
                .system("phone")
                .use("home")
                .value("0245-33553")
                .build();
    }
}
