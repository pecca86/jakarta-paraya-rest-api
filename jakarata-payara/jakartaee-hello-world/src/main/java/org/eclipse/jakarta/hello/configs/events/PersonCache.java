package org.eclipse.jakarta.hello.configs.events;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.jakarta.hello.dtos.AddPersonEvent;
import org.eclipse.jakarta.hello.dtos.Person;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonCache {

    private List<Person> persons;

    @PostConstruct
    public void init() {
        persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return persons;
    }

    // @Observes is a CDI event observer
    public void addPerson(@Observes AddPersonEvent addPersonEvent) {
        persons.add(addPersonEvent.person());
    }
}
