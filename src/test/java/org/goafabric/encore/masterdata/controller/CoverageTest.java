package org.goafabric.encore.masterdata.controller;

import org.goafabric.encore.catalogs.CoverageLogic;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CoverageTest {
    private final CoverageLogic coverageLogic = new CoverageLogic();

    @Test
    public void test() throws IOException {
        assertThat(coverageLogic.search("")).isNotNull();
        coverageLogic.search("").forEach(c -> System.out.println(c));
    }
}
