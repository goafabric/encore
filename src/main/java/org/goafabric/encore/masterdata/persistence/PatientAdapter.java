package org.goafabric.encore.masterdata.persistence;

import org.goafabric.encore.masterdata.controller.dto.Patient;

import java.util.List;

public interface PatientAdapter {

    void create(Patient patient);

    void delete(String id);

    void deleteAll();

    Patient getById(String id);

    List<Patient> search(String lastName);

}
