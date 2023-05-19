package org.goafabric.encore.catalogs.persistence.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("insurance")
@Table(name = "insurance") @Entity
public class InsuranceBo {

    @org.springframework.data.annotation.Id
    @jakarta.persistence.Id @GeneratedValue(generator = "uuid") @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String code;
    private String display;
    private String reference;
}