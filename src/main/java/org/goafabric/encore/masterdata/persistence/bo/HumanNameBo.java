
package org.goafabric.encore.masterdata.persistence.bo;

import jakarta.persistence.Embeddable;
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
@Document("humanname")
@Embeddable
public class HumanNameBo {

    private String use;
    private String family;
    private List<String> given;

}
