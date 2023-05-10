package org.goafabric.encore.ui;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@Configuration
@ImportRuntimeHints(VaadinNativeConfiguration.vaadinRuntimeHints.class)
//@RegisterReflectionForBinding({ Address.class, Person.class })
//@Theme(value = "flowcrmtutorial")
public class VaadinNativeConfiguration {//implements AppShellConfigurator {

    static class vaadinRuntimeHints implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.resources().registerPattern("en/*.yml"); //needed for stupid faker
        }
    }

}
