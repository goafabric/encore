package org.goafabric.encore.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.goafabric.encore.masterdata.controller.dto.Patient;
import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.goafabric.encore.masterdata.logic.OrganizationLogic;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;

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
    public void export(String path) {
        if (!Files.exists(Paths.get(path))) {
            throw new IllegalStateException("Path not available");
        }

        var patients = patientLogic.search("");
        Files.writeString(Paths.get(path + "/patient.json"),
                new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(patients));

        var practitioners = practitionerLogic.search("");
        Files.writeString(Paths.get(path + "/practitioner.json"),
                new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(practitioners));

        var organizations = organizationLogic.search("");
        Files.writeString(Paths.get(path + "/organization.json"),
                new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(organizations));

    }
}
