
package org.goafabric.encore.masterdata.persistence.bo;

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
@Document("address")
public class AddressBo {
    @Id
    private String id;

    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String use;

    private List<String> line;

}
