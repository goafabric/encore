package org.goafabric.encore.masterdata.repository;

import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.springframework.data.repository.CrudRepository;

public interface PractitionerRepository extends CrudRepository<Practitioner, String> {
}
