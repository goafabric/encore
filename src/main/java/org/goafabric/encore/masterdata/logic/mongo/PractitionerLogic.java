package org.goafabric.encore.masterdata.logic.mongo;

import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.masterdata.repository.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Profile("mongodb")
@Component
public class PractitionerLogic implements FhirLogic<Practitioner> {

    @Autowired
    private PractitionerRepository repository;
    
    @Override
    public void create(Practitioner Practitioner) {
        repository.save(Practitioner);    
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Practitioner getById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Practitioner> search(String search) {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
