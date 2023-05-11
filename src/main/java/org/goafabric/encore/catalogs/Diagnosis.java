package org.goafabric.encore.catalogs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Diagnosis {
    private String code;
    private String display;
    private String reference;
}
