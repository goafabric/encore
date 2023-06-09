package org.goafabric.encore.masterdata.logic;

import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.mapper.HumanNameMapper;
import org.goafabric.encore.masterdata.persistence.PractitionerRepository;
import org.goafabric.encore.masterdata.persistence.bo.PractitionerBo;
import org.goafabric.encore.xfunctional.DurationLog;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@DurationLog
@Transactional
public class PractitionerLogic implements CrudLogic<Practitioner> {
    @Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
    interface BoMapper extends HumanNameMapper {
        Practitioner map(PractitionerBo o);
        PractitionerBo map(Practitioner o);
        List<Practitioner> map(List<PractitionerBo> l);
    }

    private final BoMapper mapper;

    private final PractitionerRepository repository;

    public PractitionerLogic(BoMapper mapper, PractitionerRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public void create(Practitioner practitioner) {
        repository.save(mapper.map(practitioner));
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
        return mapper.map(repository.findById(id).get());
    }

    @Override
    public List<Practitioner> search(String search) {
        return mapper.map(repository.findByName_FamilyStartsWithIgnoreCase(search));
    }
}
