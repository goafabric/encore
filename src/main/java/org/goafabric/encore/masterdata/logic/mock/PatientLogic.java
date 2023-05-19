package org.goafabric.encore.masterdata.logic.mock;

import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.logic.CrudLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.goafabric.encore.masterdata.logic.mock.MockUtil.createPatient;

@Profile({"mock"})
@Component
public class PatientLogic implements CrudLogic<Patient> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final List<Patient> patients = new ArrayList<>();

    @Override
    public void create(Patient patient) {
        log.info("creating patient " + patient.toString());
        patients.add(patient);
    }

    @Override
    public void delete(String id) {
        //throw new IllegalStateException("NYI");
    }

    @Override
    public void deleteAll() {
        patients.clear();
    }

    @Override
    public Patient getById(String id) {
        return createPatient("Homer", "Simpson", "Evergreen Terrace 742", "0245-33553");
    }

    @Override
    public List<Patient> search(String lastName) {
        return patients.stream().filter(patient ->
                patient.getName().get(0).getFamily().toLowerCase().startsWith(lastName.toLowerCase())).toList();
    }

}
