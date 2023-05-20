
package org.goafabric.encore.masterdata.persistence.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
//@Entity @Table(name = "telecom")
@Embeddable
public class TelecomBo {

    private String system;

    @Column(name = "t_value")
    private String value;
    private String use;
}
