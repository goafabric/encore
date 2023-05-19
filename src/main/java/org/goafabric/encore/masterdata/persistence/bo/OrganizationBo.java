
package org.goafabric.encore.masterdata.persistence.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.goafabric.encore.masterdata.controller.dto.Address;
import org.goafabric.encore.masterdata.controller.dto.Telecom;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("organization")
public class OrganizationBo {

    @Id
    private String id;

    public Boolean active;
    private String name;

    private List<Telecom> telecom;
    private List<Address> address;

}
