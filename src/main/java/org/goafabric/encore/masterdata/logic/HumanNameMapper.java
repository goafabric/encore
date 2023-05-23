package org.goafabric.encore.masterdata.logic;

import org.goafabric.encore.masterdata.controller.dto.HumanName;
import org.goafabric.encore.masterdata.persistence.bo.HumanNameBo;

import java.util.Collections;
import java.util.List;

interface HumanNameMapper {
    default HumanNameBo mapName(List<HumanName> l) { return map(l.get(0)); }
    default List<HumanName> mapName(HumanNameBo o) {
        return Collections.singletonList(map(o)); }

    HumanName map(HumanNameBo o);
    HumanNameBo map(HumanName o);
}
