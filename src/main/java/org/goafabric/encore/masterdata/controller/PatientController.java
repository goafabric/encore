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

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable String id) {
        patientLogic.sayMyName("Homer"); //just for showcase
        return patientLogic.getPatient(id);
    }

    @GetMapping
    public Bundle findPatients(@RequestParam(value = "family", required = false) String familyName,
                               @RequestParam(value = "name", required = false) String name) {
        log.info("name: {}, familyName: {}", name, familyName);

        return patientLogic.findyByLastName(familyName);
    }


}
