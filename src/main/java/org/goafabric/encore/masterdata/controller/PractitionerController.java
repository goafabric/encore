package org.goafabric.encore.masterdata.controller;

import org.goafabric.encore.masterdata.controller.dto.Bundle;
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
	public void create(Practitioner practitioner) {
		practitionerLogic.create(practitioner);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		practitionerLogic.delete(id);
	}

	@GetMapping("/{id}")
	public Practitioner getById(@PathVariable String id) {
		return practitionerLogic.getById(id);
	}

	@GetMapping
	public Bundle search(@RequestParam(value = "family", required = false) String familyName,
						 @RequestParam(value = "name", required = false) String name) {

		return practitionerLogic.search(familyName);
	}

}
