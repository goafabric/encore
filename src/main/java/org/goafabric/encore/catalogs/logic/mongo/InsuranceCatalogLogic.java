package org.goafabric.encore.catalogs.logic.mongo;

import org.goafabric.encore.catalogs.dto.Insurance;
import org.goafabric.encore.catalogs.repository.InsuranceRepository;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("mongodb")
@Component
public class InsuranceCatalogLogic implements FhirLogic<Insurance> {
    @Autowired
    private InsuranceRepository repository;
    
    @Override
    public void create(Insurance Insurance) {
        repository.save(Insurance);    
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Insurance getById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Insurance> search(String search) {
        return repository.findByDisplayStartsWithIgnoreCase(search);
    }
}
