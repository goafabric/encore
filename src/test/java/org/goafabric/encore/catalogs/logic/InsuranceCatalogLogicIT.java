package org.goafabric.encore.catalogs.logic;

import org.goafabric.encore.catalogs.dto.Insurance;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class InsuranceCatalogLogicIT {
    @Autowired
    private CrudLogic<Insurance> insuranceCatalogLogic;


    @Test
    void search() {
        assertThat(insuranceCatalogLogic.search("")).isNotNull().isNotEmpty();
    }
}
