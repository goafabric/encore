package org.goafabric.encore.masterdata.controller;

import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.logic.OrganizationLogic;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "fhir/Organization", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
public class OrganizationController  {
    private final OrganizationLogic organizationLogic;

    public OrganizationController(OrganizationLogic organizationLogic) {
        this.organizationLogic = organizationLogic;
    }

    @GetMapping("/{id}")
    public Organization getOrganization(@PathVariable String id) {
        return organizationLogic.getOrganization(id);
    }
}
