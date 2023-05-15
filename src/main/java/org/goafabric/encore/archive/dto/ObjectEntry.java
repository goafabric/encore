package org.goafabric.encore.archive.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ObjectEntry {
    public String id;

    public String objectName;

    public String contentType;

    public long objectSize;

    public byte[] data;
}
