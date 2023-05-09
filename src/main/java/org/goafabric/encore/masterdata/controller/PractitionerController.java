package org.goafabric.encore.masterdata.controller;

import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.PractitionerLogic;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "fhir/Practitioner", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
public class PractitionerController {
	private final PractitionerLogic practitionerLogic;

	public PractitionerController(PractitionerLogic practitionerLogic) {
		this.practitionerLogic = practitionerLogic;
	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
	public void createPractitioner(Practitioner practitioner) {

	}

	@DeleteMapping("/{id}")
	public void deletePractitioner(@PathVariable String id) {

	}

	@GetMapping("/{id}")
	public Practitioner getPractitioner(@PathVariable String id) {
		return practitionerLogic.getPractitioner(id);
	}

}
