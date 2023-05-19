package org.goafabric.encore.masterdata.logic.mongo;

import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.masterdata.repository.OrganizationRepository;
import org.goafabric.encore.masterdata.repository.bo.OrganizationBo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("mongodb")
@Component
public class OrganizationLogic implements FhirLogic<Organization> {
    @Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
    interface BoMapper {
        Organization map(OrganizationBo o);
        OrganizationBo map(Organization o);
        List<Organization> map(List<OrganizationBo> l);
    }

    private final BoMapper mapper;
    private final OrganizationRepository repository;

    public OrganizationLogic(BoMapper mapper, OrganizationRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public void create(Organization Organization) {
        repository.save(mapper.map(Organization));
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
        return mapper.map(repository.findById(id).get());
    }

    @Override
    public List<Organization> search(String search) {
        return mapper.map(repository.findByNameStartsWithIgnoreCase(search));

    }
}
