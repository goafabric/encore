package org.goafabric.encore.catalogs.repository.bo;

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
@Document("insurance")
public class InsuranceBo {

    @Id
    private String id;

    private String code;
    private String display;
    private String reference;
}