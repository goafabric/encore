package org.goafabric.encore.masterdata.logic;

import java.util.List;

public interface FhirLogic<T> {
    List<T> search(String search);
}
