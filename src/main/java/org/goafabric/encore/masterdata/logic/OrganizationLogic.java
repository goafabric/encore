package org.goafabric.encore.masterdata.logic;

import lombok.experimental.Delegate;
import org.goafabric.encore.crossfunctional.DurationLog;
import org.goafabric.encore.masterdata.persistence.OrganizationAdapter;
import org.springframework.stereotype.Component;

@Component
@DurationLog
public class OrganizationLogic {
    @Delegate
    private final OrganizationAdapter organizationAdapter;

    public OrganizationLogic(OrganizationAdapter organizationAdapter) {
        this.organizationAdapter = organizationAdapter;
    }
}
