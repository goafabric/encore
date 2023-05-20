package org.goafabric.encore.catalogs.persistence.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
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
@Entity @Table(name = "insurance")
public class InsuranceBo {

    @org.springframework.data.annotation.Id
    @jakarta.persistence.Id @jakarta.persistence.GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String code;
    private String display;
    private String reference;
}