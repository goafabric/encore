
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
@Document("practitioner")
@Entity @Table(name = "practitioner")
public class PractitionerBo {

    @org.springframework.data.annotation.Id
    @jakarta.persistence.Id @jakarta.persistence.GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    public Boolean active;
    private String gender;
    private String birthDate;

    @ElementCollection
    private List<HumanNameBo> name;

    @ElementCollection
    private List<TelecomBo> telecom;

    @ElementCollection
    private List<AddressBo> address;

}
