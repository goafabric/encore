package org.goafabric.encore.catalogs;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class DiagnosisCatalogLogic {
    final List<Diagnosis> Diagnosiss;
    public DiagnosisCatalogLogic() {
        Diagnosiss = readDiagnosiss();
    }

    private List<Diagnosis> readDiagnosiss() {
        List<String> lines = loadFile("catalogs/icd10.csv");

        return lines.stream().map(line -> Diagnosis.builder()
                .code(line.split(";")[0]).display(line.split(";")[1]).reference(line.split(";")[2])
                .build()).toList();
    }

    public List<Diagnosis> search(String display) {
        return Diagnosiss.stream().filter(i -> i.getDisplay().toLowerCase().startsWith(display.toLowerCase())).toList();
    }

    private static List<String> loadFile(String fileName)  {
        try {
            return Arrays.asList(new String(new ClassPathResource(fileName).getInputStream()
                    .readAllBytes()).split("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
