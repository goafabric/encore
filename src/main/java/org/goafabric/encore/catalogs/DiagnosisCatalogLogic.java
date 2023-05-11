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
        final List<Diagnosis> diagnosis;
        List<String> lines = null;
        try {
            lines = Files.readAllLines(new ClassPathResource("catalogs/icd10.csv").getFile().toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        diagnosis = lines.stream().map(line -> Diagnosis.builder()
                .code(line.split(";")[0]).display(line.split(";")[1]).reference(line.split(";")[2])
                .build()).toList();

        //lines.stream().forEach(line -> System.out.println(line.split(";")[0] + line.split(";")[1] + line.split(";")[2]));
        return diagnosis;
    }

    public List<Diagnosis> search(String display) {
        return Diagnosiss.stream().filter(i -> i.getDisplay().toLowerCase().startsWith(display.toLowerCase())).toList();
    }
}
