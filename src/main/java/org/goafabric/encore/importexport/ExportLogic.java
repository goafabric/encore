package org.goafabric.encore.importexport;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.goafabric.encore.masterdata.controller.dto.Organization;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class ExportLogic {
    private final FhirLogic<Patient> patientLogic;
    private final FhirLogic<Practitioner> practitionerLogic;
    private final FhirLogic<Organization> organizationLogic;

    public ExportLogic(FhirLogic<Patient> patientLogic, FhirLogic<Practitioner> practitionerLogic, FhirLogic<Organization> organizationLogic) {
        this.patientLogic = patientLogic;
        this.practitionerLogic = practitionerLogic;
        this.organizationLogic = organizationLogic;
    }

    @SneakyThrows
    public void run(String path) {
        if (!Files.exists(Paths.get(path))) {
            throw new IllegalStateException("Path not available");
        }

        exportPatient(path);
        exportPractitioners(path);
        exportOrganizations(path);
    }

    private void exportPatient(String path) throws IOException {
        var patients = patientLogic.search("");
        Files.writeString(Paths.get(path + "/patient.json"),
                new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(patients));
    }

    private void exportPractitioners(String path) throws IOException {
        var practitioners = practitionerLogic.search("");
        Files.writeString(Paths.get(path + "/practitioner.json"),
                new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(practitioners));
    }

    private void exportOrganizations(String path) throws IOException {
        var organizations = organizationLogic.search("");
        Files.writeString(Paths.get(path + "/organization.json"),
                new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(organizations));
    }

}
