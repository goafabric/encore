
package org.goafabric.encore.masterdata.controller.dto;

import com.vaadin.flow.component.template.Id;
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
public class Practitioner {

    @Id
    private String id;
    public Meta meta;
    private String resourceType = "Practitioner";

    public Boolean active;
    private String gender;
    private String birthDate;

    private List<HumanName> name;
    private List<Identifier> identifier;
    private List<Telecom> telecom;
    private List<Address> address;

}
