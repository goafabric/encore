package org.goafabric.encore.masterdata.persistence.mock;

import org.goafabric.encore.masterdata.controller.dto.Address;
import org.goafabric.encore.masterdata.controller.dto.AdressUse;
import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.persistence.OrganizationAdapter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Profile("mock")
@Component
public class OrganizationMockAdapter implements OrganizationAdapter {
    public Organization getOrganization(String id) {
        return Organization.builder()
                .id(id)
                .name("Krust Burger")
                .address(Arrays.asList(createAddress()))
                .build();
    }


    private Address createAddress() {
        return Address.builder()
                .id("22")
                .city("Springfield")
                .postalCode("78313")
                .country("US")
                .line(List.of("Clownstreet 452"))
                .use(AdressUse.HOME.getValue())
                .build();
    }

}
