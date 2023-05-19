package org.goafabric.encore.masterdata.controller;

import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.goafabric.encore.masterdata.logic.mock.MockUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "fhir/Organization", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
public class OrganizationController  {
    private final CrudLogic<Organization> organizationLogic;

    public OrganizationController(CrudLogic<Organization> organizationLogic) {
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

    @GetMapping
    public Bundle search(@RequestParam(value = "name", required = false) String name) {
        var bundle = new Bundle<Organization>();
        organizationLogic.search(name).forEach(p -> bundle.addEntry(MockUtil.createBundleEntry(p, p.getId())));
        return bundle;
    }

}
