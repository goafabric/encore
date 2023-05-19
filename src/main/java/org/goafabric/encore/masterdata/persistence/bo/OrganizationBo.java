
package org.goafabric.encore.masterdata.persistence.bo;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.goafabric.encore.masterdata.controller.dto.Address;
import org.goafabric.encore.masterdata.controller.dto.Telecom;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("organization")
//@Entity @Table(name = "organization")
public class OrganizationBo {

    @org.springframework.data.annotation.Id
    @jakarta.persistence.Id @GeneratedValue(generator = "uuid") @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    public Boolean active;
    private String name;

    private List<Telecom> telecom;
    private List<Address> address;

}
