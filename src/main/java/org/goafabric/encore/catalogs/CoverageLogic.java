package org.goafabric.encore.catalogs;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Component
public class CoverageLogic {
    final List<Insurance> insurances;
    public CoverageLogic() {
        insurances = readInsurances();
    }

    private List<Insurance> readInsurances() {
        final List<Insurance> insurances;
        List<String> lines = null;
        try {
            lines = Files.readAllLines(new ClassPathResource("catalogs/insurance_pkv.csv").getFile().toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        insurances = lines.stream().map(line -> Insurance.builder()
                .id(line.split(";")[0]).display(line.split(";")[1]).reference(line.split(";")[2])
                .build()).toList();
        return insurances;
    }

    public List<Insurance> search(String display) {
        return insurances.stream().filter(i -> i.getDisplay().toLowerCase().startsWith(display.toLowerCase())).toList();
    }
}
