package org.goafabric.encore.catalogs.persistence.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Document("chargeitem")
@Entity @Table(name = "chargeitem")
public class ChargeItemBo {
    @org.springframework.data.annotation.Id
    @jakarta.persistence.Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String code;
    private String display;
    private Double price;
}
