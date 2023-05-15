package org.goafabric.encore.masterdata.logic.mock;

import org.goafabric.encore.masterdata.controller.dto.Practitioner;
import org.goafabric.encore.masterdata.logic.FhirLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Profile("mock")
@Component
public class PractitionerLogic implements FhirLogic<Practitioner> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final List<Practitioner> practitioners = new ArrayList<>();

    public PractitionerLogic() {
        practitioners.add(MockUtil.createPractitioner("Dr Julius", "Hibbert", "Commonstreet 345", "555-520"));
        practitioners.add(MockUtil.createPractitioner("Dr Marvin", "Monroe", "Psychestreet 104", "555-525"));
        practitioners.add(MockUtil.createPractitioner("Dr Nick", "Riveria", "Nickstreet 221", "555-501"));
    }

    @Override
    public void create(Practitioner practitioner) {
        log.info("creating practitioner " + practitioner.toString());
        practitioners.add(practitioner);
    }

    @Override
    public void delete(String id) {
        //throw new IllegalStateException("NYI");
    }

    @Override
    public void deleteAll() {
        practitioners.clear();
    }

    @Override
    public Practitioner getById(String id) {
        return practitioners.get(0);
    }


    @Override
    public List<Practitioner> search(String lastName) {
        return practitioners.stream().filter(patient ->
                        patient.getName().get(0).getFamily().toLowerCase().startsWith(lastName.toLowerCase())).toList();
    }

}
