package org.goafabric.encore.catalogs;

import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Component
public class InsuranceCatalogLogic implements FhirLogic<Insurance> {
    final List<Insurance> insurances;
    public InsuranceCatalogLogic() {
        insurances = readInsurances();
    }


    @Override
    public void create(Insurance insurance) {

    }

    @Override
    public void delete(String id) {
        throw new IllegalStateException("NYI");
    }

    @Override
    public void deleteAll() {
        insurances.clear();
    }

    @Override
    public Insurance getById(String id) {
        throw new IllegalStateException("NYI");
    }

    public List<Insurance> search(String display) {
        return insurances.stream().filter(i -> i.getDisplay().toLowerCase().startsWith(display.toLowerCase())).toList();
    }

    private static List<String> loadFile(String fileName)  {
        try {
            return Arrays.asList(new String(new ClassPathResource(fileName).getInputStream()
                    .readAllBytes(), StandardCharsets.UTF_8).split("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Insurance> readInsurances() {
        List<String> lines = loadFile("catalogs/insurance_pkv.csv");

        return lines.stream().map(line -> Insurance.builder()
                .code(line.split(";")[0]).display(line.split(";")[1]).reference(line.split(";")[2])
                .build()).toList();
    }

}
