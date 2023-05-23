package org.goafabric.encore.masterdata.controller;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Practitioner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PractitionerControllerIT {
    @LocalServerPort
    private String port;

    @Test
    @Disabled
    void getPractitioner() {
        final IGenericClient client = ClientFactory.createClient(port);

        final Practitioner practitioner =
                client.read()
                        .resource(Practitioner.class)
                        .withId("1").execute();

        assertThat(practitioner).isNotNull();
    }

    /*
    @Test
    void create() {
        final IGenericClient client = ClientFactory.createClient(port);
        var practitioner = new Practitioner();
        practitioner.setName(Collections.singletonList(new HumanName().setFamily("none")));

        client.create().resource(practitioner).execute();
    }

     */

    @Test
    void delete() {
        final IGenericClient client = ClientFactory.createClient(port);
        client.delete().resourceById(new IdType("Practitioner", "1")).execute();
    }
}