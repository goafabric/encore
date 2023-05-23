package org.goafabric.encore.masterdata.logic;

import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.logic.mapper.HumanNameMapper;
import org.goafabric.encore.masterdata.persistence.PatientRepository;
import org.goafabric.encore.masterdata.persistence.bo.PatientBo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PatientLogic implements CrudLogic<Patient> {
    @Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
    interface BoMapper extends HumanNameMapper {
        Patient map(PatientBo o);
        PatientBo map(Patient o);
        List<Patient> map(List<PatientBo> l);
    }

    private final BoMapper mapper;

    private final PatientRepository repository;

    public PatientLogic(BoMapper mapper, PatientRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

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
        return mapper.map(repository.findByName_FamilyStartsWithIgnoreCase(search));
    }
}
