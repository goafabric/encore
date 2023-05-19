
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
@Document("address")
//@Entity @Table(name = "address")
@Embeddable
public class AddressBo {
    /*
    @org.springframework.data.annotation.Id
    @jakarta.persistence.Id @GeneratedValue(generator = "uuid") @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
     */

    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String use;

    private List<String> line;

}
