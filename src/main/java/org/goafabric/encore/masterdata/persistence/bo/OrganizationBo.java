
package org.goafabric.encore.masterdata.persistence.bo;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("organization")
@Entity @Table(name = "organization")
public class OrganizationBo {

    @org.springframework.data.annotation.Id
    @jakarta.persistence.Id @jakarta.persistence.GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    public Boolean active;
    private String name;

    @ElementCollection
    private List<TelecomBo> telecom;

    @ElementCollection
    private List<AddressBo> address;

}
