package org.goafabric.encore.files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.masterdata.logic.OrganizationLogic;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class ImportLogic {
    private final FhirLogic<Patient> patientLogic;
    private final FhirLogic<Practitioner> practitionerLogic;
    private final OrganizationLogic organizationLogic;

    public ImportLogic(FhirLogic<Patient> patientLogic, FhirLogic<Practitioner> practitionerLogic, OrganizationLogic organizationLogic) {
        this.patientLogic = patientLogic;
        this.practitionerLogic = practitionerLogic;
        this.organizationLogic = organizationLogic;
    }

    @SneakyThrows
    public void run(String path) {
        if (!Files.exists(Paths.get(path))) {
            throw new IllegalStateException("Path not available");
        }

        var patients = new ObjectMapper().readValue(new File(path + "/patient.json"), new TypeReference<List<Patient>>() {});
        patients.forEach(patientLogic::create);

        var practitioners = new ObjectMapper().readValue(new File(path + "/practitioner.json"), new TypeReference<List<Practitioner>>() {});
        practitioners.forEach(practitionerLogic::create);

        var organizations = new ObjectMapper().readValue(new File(path + "/organization.json"), new TypeReference<List<Organization>>() {});
        organizations.forEach(organizationLogic::create);

    }


}
