package org.goafabric.encore.masterdata.controller;

import org.goafabric.encore.catalogs.logic.mock.DiagnosisCatalogLogic;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class DiagnosisTest {
    private final DiagnosisCatalogLogic catalogLogic = new DiagnosisCatalogLogic();

    @Test
    public void test() throws IOException {
        assertThat(catalogLogic.search("")).isNotNull();
        catalogLogic.search("").forEach(c -> System.out.println(c));
    }
}
