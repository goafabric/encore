package org.goafabric.encore.catalogs.logic.mock;

import org.goafabric.encore.catalogs.dto.Diagnosis;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.xfunctional.DurationLog;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Profile("mock")
@Component
public class DiagnosisCatalogLogic implements FhirLogic<Diagnosis> {
    final List<Diagnosis> diagnosis = new ArrayList<>();

    @Override
    public void create(Diagnosis diagnosis) {
        this.diagnosis.add(diagnosis);
    }

    @Override
    public void delete(String id) {
        throw new IllegalStateException("NYI");
    }

    @Override
    public void deleteAll() {
        diagnosis.clear();
    }

    @Override
    public Diagnosis getById(String id) {
        throw new IllegalStateException("NYI");
    }

    @DurationLog
    public List<Diagnosis> search(String display) {
        return diagnosis.stream().filter(i -> i.getDisplay().toLowerCase().startsWith(display.toLowerCase())).toList();
    }

}
