package org.goafabric.encore.catalogs;

import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Component
public class DiagnosisCatalogLogic implements FhirLogic<Diagnosis> {
    final List<Diagnosis> diagnosis;
    public DiagnosisCatalogLogic() {
        diagnosis = readDiagnosiss();
    }

    private List<Diagnosis> readDiagnosiss() {
        List<String> lines = loadFile("catalogs/icd10.csv");

        return lines.stream().map(line -> Diagnosis.builder()
                .code(line.split(";")[0]).display(line.split(";")[1]).reference(line.split(";")[2])
                .build()).toList();
    }

    public List<Diagnosis> search(String display) {
        return diagnosis.stream().filter(i -> i.getDisplay().toLowerCase().startsWith(display.toLowerCase())).toList();
    }

    @Override
    public void create(Diagnosis diagnosis) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Diagnosis getById(String id) {
        return null;
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
