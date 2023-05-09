package org.goafabric.encore.masterdata.controller;

import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.logic.BundleLogic;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "fhir/Bundle", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
public class BundleController {
    private final BundleLogic bundleLogic;
    public BundleController(BundleLogic bundleLogic) {
        this.bundleLogic = bundleLogic;
    }

    @GetMapping("{id}")
    public Bundle getBundle(String id) {
        return bundleLogic.getBundle(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
    public void createBundle(Bundle bundle) {
        bundleLogic.createBundle(bundle);
    }

}
