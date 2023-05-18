
package org.goafabric.encore.masterdata.controller.dto;

import com.vaadin.flow.component.template.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("patient")
public class Patient {

    //@JacksonXmlProperty(isAttribute = true) private final String xmlns = "http://hl7.org/fhir";

    @Id
    private String id;
    public Meta meta;

    @Transient
    private final String resourceType = "Patient";

    private String gender;
    private String birthDate;

    private List<Identifier> identifier;
    private List<HumanName> name;
    private List<Telecom> telecom;
    private List<Address> address;

}
