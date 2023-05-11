package org.goafabric.encore.ui;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.goafabric.encore.masterdata.controller.dto.*;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ImportRuntimeHints(VaadinNativeConfiguration.vaadinRuntimeHints.class)
@RegisterReflectionForBinding({ Patient.class, Practitioner.class, Organization.class, Address.class, Telecom.class })
@Theme(value = "default")
public class VaadinNativeConfiguration implements AppShellConfigurator {

    static class vaadinRuntimeHints implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.resources().registerPattern("en/*.yml"); //needed for stupid faker
            //hints.resources().registerPattern("catalogs/*.csv");
            hints.resources().registerResource(new ClassPathResource("catalogs/icd10.csv"));
            hints.resources().registerResource(new ClassPathResource("catalogs/insurance_pkv.csv"));
        }
    }

}
