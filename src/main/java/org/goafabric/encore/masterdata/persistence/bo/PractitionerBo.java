
package org.goafabric.encore.masterdata.persistence.bo;

import com.vaadin.flow.component.template.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.goafabric.encore.masterdata.controller.dto.HumanName;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("practitioner")
public class PractitionerBo {

    @Id
    private String id;

    public Boolean active;
    private String gender;
    private String birthDate;

    private List<HumanName> name;
    private List<TelecomBo> telecom;
    private List<AddressBo> address;

}
