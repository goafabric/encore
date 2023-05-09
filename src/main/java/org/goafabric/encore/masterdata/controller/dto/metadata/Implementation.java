
package org.goafabric.encore.masterdata.controller.dto.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Implementation {

    @JsonProperty("description")
    private String description;
    @JsonProperty("url")
    private String url;

}
