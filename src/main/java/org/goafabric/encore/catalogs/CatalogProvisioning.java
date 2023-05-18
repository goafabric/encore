package org.goafabric.encore.catalogs;

import lombok.extern.slf4j.Slf4j;
import org.goafabric.encore.catalogs.dto.Diagnosis;
import org.goafabric.encore.catalogs.dto.Insurance;
import org.goafabric.encore.catalogs.logic.mock.DiagnosisCatalogLogic;
import org.goafabric.encore.catalogs.logic.mock.InsuranceCatalogLogic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class CatalogProvisioning implements CommandLineRunner {
    @Value("${database.provisioning.goals:}")
    String goals;

    private final ApplicationContext applicationContext;
    private final DiagnosisCatalogLogic diagnosisCatalogLogic;
    private final InsuranceCatalogLogic insuranceCatalogLogic;

    public CatalogProvisioning(ApplicationContext applicationContext,
                               DiagnosisCatalogLogic diagnosisCatalogLogic, InsuranceCatalogLogic insuranceCatalogLogic) {
        this.applicationContext = applicationContext;
        this.diagnosisCatalogLogic = diagnosisCatalogLogic;
        this.insuranceCatalogLogic = insuranceCatalogLogic;
    }


    @Override
    public void run(String... args) throws Exception {
        if (goals.contains("-import-catalog-data")) {
            log.info("Importing catalog data ...");
            importDemoData();
            log.info("Catalog data import done ...");
        }

        if (goals.contains("-terminate")) {
            log.info("Terminating app ...");
            SpringApplication.exit(applicationContext, () -> 0); //if an exception is raised, spring will automatically terminate with 1
        }
    }

    private void importDemoData() {
        readDiagnosiss();
        readInsurances();
    }

    private void readDiagnosiss() {
        loadFile("catalogs/icd10.csv").forEach(line -> diagnosisCatalogLogic.create(Diagnosis.builder()
                .code(line.split(";")[0])
                .display(line.split(";")[1])
                .reference(line.split(";")[2]).build()
        ));
    }

    private void readInsurances() {
        loadFile("catalogs/insurance_pkv.csv").forEach(line -> insuranceCatalogLogic.create(Insurance.builder()
                .code(line.split(";")[0])
                .display(line.split(";")[1])
                .reference(line.split(";")[2]).build()
        ));
    }


    private static List<String> loadFile(String fileName)  {
        try {
            return Arrays.asList(new String(new ClassPathResource(fileName).getInputStream()
                    .readAllBytes(), StandardCharsets.UTF_8).split("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
