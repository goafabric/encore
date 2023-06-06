
package org.goafabric.encore.masterdata.persistence.bo;

import jakarta.persistence.*;
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
    @jakarta.persistence.Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    public Boolean active;
    private String gender;
    private String birthDate;

    @Embedded
    private HumanNameBo name;

    @ElementCollection
    private List<TelecomBo> telecom;

    @ElementCollection
    private List<AddressBo> address;

}
