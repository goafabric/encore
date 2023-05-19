package org.goafabric.encore.masterdata.logic.mongo;

import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.masterdata.persistence.PractitionerRepository;
import org.goafabric.encore.masterdata.persistence.bo.PractitionerBo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.StreamSupport;

@Profile({"mongodb", "jpa"})
@Component
@Transactional
public class PractitionerLogic implements CrudLogic<Practitioner> {
    @Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
    interface BoMapper {
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
        var practitioners =  StreamSupport.stream(repository.findAll().spliterator(), false).toList();
        return mapper.map(practitioners.stream().filter(p ->
                p.getName().get(0).getFamily().toLowerCase().startsWith(search.toLowerCase())).toList());

    }
}
