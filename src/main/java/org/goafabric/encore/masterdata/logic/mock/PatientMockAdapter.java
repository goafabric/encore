package org.goafabric.encore.masterdata.logic.mock;

import net.datafaker.Faker;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.goafabric.encore.masterdata.logic.mock.MockUtil.createPatient;

@Profile("mock")
@Component
public class PatientMockAdapter implements FhirLogic<Patient> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final List<Patient> patients = new ArrayList<>();

    public PatientMockAdapter() {
        Faker faker = new Faker();

        patients.add(createPatient("Homer", "Simpson", "Evergreen Terrace 742", "0245-33553"));

        IntStream.range(0, 50).forEach(i -> patients.add(
                createPatient(faker.name().firstName(), faker.name().lastName(), faker.simpsons().location(), "0245-43553")));
    }

    @Override
    public void create(Patient patient) {
        log.info("creating patient " + patient.toString());
        patients.add(patient);
    }

    @Override
    public void delete(String id) {
        log.info("deleting patient" + id);
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