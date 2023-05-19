package org.goafabric.encore.catalogs.persistence.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("diagnosis")
public class DiagnosisBo {
    @Id
    private String id;

    private String code;
    private String display;
    private String reference;
}
