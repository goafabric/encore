
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
@Document("patient")
@Entity @Table(name = "patient")
public class PatientBo {

    @org.springframework.data.annotation.Id
    @jakarta.persistence.Id @jakarta.persistence.GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String gender;
    private String birthDate;

    @ElementCollection
    private List<HumanNameBo> name;

    @ElementCollection
    private List<TelecomBo> telecom;

    @ElementCollection
    private List<AddressBo> address;

}
