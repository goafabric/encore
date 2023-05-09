package org.goafabric.encore.masterdata.controller.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.goafabric.encore.masterdata.controller.dto.Organization;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TIConfigurationPojo {
    //Custom Fields
    private String clientSystemId;
    private String mandantId;
    private String workplaceId;

    //Standard FHIR Resource Organization
    private Organization organization;
}