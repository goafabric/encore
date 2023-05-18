package org.goafabric.encore.masterdata.logic.mongo;

import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.masterdata.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Profile("mongodb")
@Component
public class PatientLogic implements FhirLogic<Patient> {

    @Autowired
    private PatientRepository repository;

    @Override
    public void create(Patient patient) {
        repository.save(patient);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Patient getById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Patient> search(String search) {
        var patients =  StreamSupport.stream(repository.findAll().spliterator(), false).toList();
        return patients.stream().filter(patient ->
                patient.getName().get(0).getFamily().toLowerCase().startsWith(search.toLowerCase())).toList();
    }
}
