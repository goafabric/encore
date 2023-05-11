package org.goafabric.encore.catalogs;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Component
public class DiagnosisCatalogLogic {
    final List<Diagnosis> Diagnosiss;
    public DiagnosisCatalogLogic() {
        Diagnosiss = readDiagnosiss();
    }

    private List<Diagnosis> readDiagnosiss() {
        final List<Diagnosis> Diagnosiss;
        List<String> lines = null;
        try {
            lines = Files.readAllLines(new ClassPathResource("catalogs/icd10.csv").getFile().toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Diagnosiss = lines.stream().map(line -> Diagnosis.builder()
                .code(line.split(";")[0]).display(line.split(";")[1]).reference(line.split(";")[2])
                .build()).toList();
        return Diagnosiss;
    }

    public List<Diagnosis> search(String display) {
        return Diagnosiss.stream().filter(i -> i.getDisplay().toLowerCase().startsWith(display.toLowerCase())).toList();
    }
}
