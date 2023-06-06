package org.goafabric.encore.catalogs.logic;

import org.goafabric.encore.catalogs.dto.ChargeItem;
import org.goafabric.encore.catalogs.persistence.ChargeItemRepository;
import org.goafabric.encore.catalogs.persistence.bo.ChargeItemBo;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ChargeItemCatalogLogic implements CrudLogic<ChargeItem> {
    @Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
    interface BoMapper {
        ChargeItem map(ChargeItemBo o);
        ChargeItemBo map(ChargeItem o);
        List<ChargeItem> map(List<ChargeItemBo> l);
    }

    private BoMapper mapper;
    private ChargeItemRepository repository;

    public ChargeItemCatalogLogic(BoMapper mapper, ChargeItemRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public void create(ChargeItem ChargeItem) {
        repository.save(mapper.map(ChargeItem));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public ChargeItem getById(String id) {
        return mapper.map(repository.findById(id).get());
    }

    @Override
    public List<ChargeItem> search(String search) {
        return mapper.map(repository.findByDisplayStartsWithIgnoreCase(search));
    }
}
