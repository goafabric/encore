
package org.goafabric.encore.masterdata.persistence.bo;

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
    /*
    @org.springframework.data.annotation.Id
    @jakarta.persistence.Id @GeneratedValue(generator = "uuid") @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

     */

    private String system;
    private String tvalue;
    private String use;
}
