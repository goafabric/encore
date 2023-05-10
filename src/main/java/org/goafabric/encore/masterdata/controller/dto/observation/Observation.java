
package org.goafabric.encore.masterdata.controller.dto.observation;

import lombok.Data;
import org.goafabric.encore.masterdata.controller.dto.Meta;

@Data
public class Observation {

    private String id;
    public Meta meta;
    private String resourceType;

    public Text text;
    private String status;
    public Subject subject;
    private String effectiveDateTime;
    public ValueSampledData valueSampledData;

}
