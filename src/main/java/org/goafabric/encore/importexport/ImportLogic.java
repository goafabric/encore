package org.goafabric.encore.importexport;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class ImportLogic {
    private final FhirLogic<Patient> patientLogic;
    private final FhirLogic<Practitioner> practitionerLogic;
    private final FhirLogic<Organization> organizationLogic;

    public ImportLogic(FhirLogic<Patient> patientLogic, FhirLogic<Practitioner> practitionerLogic, FhirLogic<Organization> organizationLogic) {
        this.patientLogic = patientLogic;
        this.practitionerLogic = practitionerLogic;
        this.organizationLogic = organizationLogic;
    }

    @SneakyThrows
    public void run(String path) {
        if (!Files.exists(Paths.get(path))) {
            throw new IllegalStateException("Path not available");
        }

        importPatients(path);
        importPractitioners(path);
        importOrganizations(path);
    }

    private void importOrganizations(String path) throws IOException {
        var organizations = new ObjectMapper().readValue(new File(path + "/organization.json"), new TypeReference<List<Organization>>() {});
        organizationLogic.deleteAll();
        organizations.forEach(organizationLogic::create);
    }

    private void importPractitioners(String path) throws IOException {
        var practitioners = new ObjectMapper().readValue(new File(path + "/practitioner.json"), new TypeReference<List<Practitioner>>() {});
        practitionerLogic.deleteAll();
        practitioners.forEach(practitionerLogic::create);
    }

    private void importPatients(String path) throws IOException {
        var patients = new ObjectMapper().readValue(new File(path + "/patient.json"), new TypeReference<List<Patient>>() {});
        patientLogic.deleteAll();
        patients.forEach(patientLogic::create);
    }


}
