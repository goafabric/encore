
package org.goafabric.encore.masterdata.repository.bo;

import com.vaadin.flow.component.template.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("telecom")
public class TelecomBo {
    @Id
    private String id;

    private String system;
    private String value;
    private String use;

}
