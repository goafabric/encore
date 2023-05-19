package org.goafabric.encore.masterdata.logic.mongo;

import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.masterdata.repository.PatientRepository;
import org.goafabric.encore.masterdata.repository.bo.PatientBo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Profile("mongodb")
@Component
public class PatientLogic implements FhirLogic<Patient> {
    @Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
    interface PatientMapper {
        Patient map(PatientBo p);
        PatientBo map(Patient p);
        List<Patient> map(List<PatientBo> l);
    }

    @Autowired
    private PatientRepository repository;

    @Autowired
    private PatientMapper mapper;

    @Override
    public void create(Patient patient) {
        repository.save(mapper.map(patient));
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
        return mapper.map(repository.findById(id).get());
    }

    @Override
    public List<Patient> search(String search) {
        var patients =  StreamSupport.stream(repository.findAll().spliterator(), false).toList();
        return mapper.map(patients.stream().filter(patient ->
                patient.getName().get(0).getFamily().toLowerCase().startsWith(search.toLowerCase())).toList());
    }
}
