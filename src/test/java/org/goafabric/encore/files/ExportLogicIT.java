package org.goafabric.encore.files;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExportLogicIT {
    @Autowired
    private ExportLogic exportLogic;

    @Test
    void export() {
        //exportLogic.export("/Users/andreas/Downloads");
    }
}
