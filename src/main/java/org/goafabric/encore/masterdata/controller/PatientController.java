package org.goafabric.encore.masterdata.controller;


import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.logic.PatientLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "fhir/Patient", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
public class PatientController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PatientLogic patientLogic;

    public PatientController(PatientLogic patientLogic) {
        this.patientLogic = patientLogic;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
    public void create(Patient patient) {
        patientLogic.create(patient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        patientLogic.delete(id);
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable String id) {
        return patientLogic.getPatient(id);
    }

    @GetMapping
    public Bundle search(@RequestParam(value = "family", required = false) String familyName,
                               @RequestParam(value = "name", required = false) String name) {
        log.info("name: {}, familyName: {}", name, familyName);

        return patientLogic.search(familyName);
    }

}
