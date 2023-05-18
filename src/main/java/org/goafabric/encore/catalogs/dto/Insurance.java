package org.goafabric.encore.catalogs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("insurance")
public class Insurance {
    private String code;
    private String display;
    private String reference;
}