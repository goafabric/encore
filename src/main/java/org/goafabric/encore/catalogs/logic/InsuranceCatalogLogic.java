package org.goafabric.encore.catalogs.logic;

import org.goafabric.encore.catalogs.dto.Insurance;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.xfunctional.DurationLog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InsuranceCatalogLogic implements FhirLogic<Insurance> {
    final List<Insurance> insurances = new ArrayList<>();
    public InsuranceCatalogLogic() {
    }


    @Override
    public void create(Insurance insurance) {
        insurances.add(insurance);
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

    @DurationLog
    public List<Insurance> search(String display) {
        return insurances.stream().filter(i -> i.getDisplay().toLowerCase().startsWith(display.toLowerCase())).toList();
    }

}
