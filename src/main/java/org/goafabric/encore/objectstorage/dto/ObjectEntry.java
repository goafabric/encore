package org.goafabric.encore.objectstorage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ObjectEntry {
    private String id;

    private String objectName;

    private String contentType;

    private long objectSize;

    private byte[] data;
}
