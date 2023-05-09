package org.goafabric.encore.masterdata.controller;

import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.logic.OrganizationLogic;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "fhir/Organization", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
public class OrganizationController  {
    private final OrganizationLogic organizationLogic;

    public OrganizationController(OrganizationLogic organizationLogic) {
        this.organizationLogic = organizationLogic;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
    public void create(Organization organization) {
        organizationLogic.create(organization);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        organizationLogic.delete(id);
    }

    @GetMapping("/{id}")
    public Organization getById(@PathVariable String id) {
        return organizationLogic.getById(id);
    }
}
