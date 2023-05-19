
package org.goafabric.encore.masterdata.persistence.bo;

import com.vaadin.flow.component.template.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.goafabric.encore.masterdata.controller.dto.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("patient")
public class PatientBo {

    @Id
    private String id;

    private String gender;
    private String birthDate;

    private List<HumanName> name;
    private List<TelecomBo> telecom;
    private List<AddressBo> address;

}
