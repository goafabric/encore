package org.goafabric.encore.masterdata.logic.mongo;

import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.masterdata.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("mongodb")
@Component
public class OrganizationLogic implements FhirLogic<Organization> {

    @Autowired
    private OrganizationRepository repository;
    
    @Override
    public void create(Organization Organization) {
        repository.save(Organization);    
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Organization getById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Organization> search(String search) {
        return repository.findByNameStartsWithIgnoreCase(search);
        //return StreamSupport.stream(repository.findAll().spliterator(), false)
          //      .collect(Collectors.toList());
    }
}
