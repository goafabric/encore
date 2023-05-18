package org.goafabric.encore.catalogs.logic.mongo;

import org.goafabric.encore.catalogs.dto.Diagnosis;
import org.goafabric.encore.catalogs.repository.DiagnosisRepository;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("mongodb")
@Component
public class DiagnosisCatalogLogic implements FhirLogic<Diagnosis> {
    @Autowired
    private DiagnosisRepository repository;

    @Override
    public void create(Diagnosis diagnosis) {
        repository.save(diagnosis);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Diagnosis getById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Diagnosis> search(String search) {
        return repository.findByDisplayStartsWithIgnoreCase(search);
    }
}
