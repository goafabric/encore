package org.goafabric.encore.masterdata.persistence.mock;

import org.goafabric.encore.masterdata.controller.dto.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class MockUtil {
    public static List<Address> createAddress(String street) {
        return Collections.singletonList(
                Address.builder()
                .id(UUID.randomUUID().toString())
                .city("Springfield")
                .postalCode("78313")
                .country("US")
                .line(List.of(street))
                .use(AdressUse.HOME.getValue())
                .build());
    }

    public static List<HumanName> createName(String given, String family) {
        return Collections.singletonList(
                HumanName.builder()
                .given(Collections.singletonList(given))
                .family(family)
                //.familyExtension(new ExtensionWrapper().addExtension("http://fhir.de/StructureDefinition/humanname-namenszusatz/0.2", "The 3rd"))
                .build());
    }

    public static List<Telecom> createTelecom(String value) {
        return Collections.singletonList(
                Telecom.builder()
                .id(UUID.randomUUID().toString())
                .system(TelecomSystem.PHONE.getValue())
                .use(AdressUse.HOME.getValue())
                .value(value)
                .build());
    }

}
