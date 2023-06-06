package org.goafabric.encore.catalogs.persistence;

import org.goafabric.encore.catalogs.persistence.bo.ChargeItemBo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChargeItemRepository extends CrudRepository<ChargeItemBo, String> {
    List<ChargeItemBo> findByDisplayStartsWithIgnoreCase(String display);
}
