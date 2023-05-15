package org.goafabric.encore.masterdata.controller;

import org.goafabric.encore.masterdata.controller.dto.Bundle;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.masterdata.logic.mock.MockUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "fhir/Practitioner", produces = {MediaType.APPLICATION_JSON_VALUE, "application/fhir+json"})
public class PractitionerController {
	private final FhirLogic<Practitioner> practitionerLogic;

	public PractitionerController(FhirLogic<Practitioner> practitionerLogic) {
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
		var bundle = new Bundle<Practitioner>();
		practitionerLogic.search(familyName).forEach(p -> bundle.addEntry(MockUtil.createBundleEntry(p, p.getId())));
		return bundle;
	}

}
