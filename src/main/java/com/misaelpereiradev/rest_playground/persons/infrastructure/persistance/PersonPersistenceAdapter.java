package com.misaelpereiradev.rest_playground.persons.infrastructure.persistance;

import com.misaelpereiradev.rest_playground.persons.domain.model.Person;
import com.misaelpereiradev.rest_playground.persons.domain.port.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonPersistenceAdapter implements PersonRepository {
    private List<Person> persons;
    private long personId = 0L;

    @PostConstruct
    public void onInit() {
        persons = new ArrayList<>();
        persons.add(Person.builder()
                .id(++personId)
                .name("Misael")
                .age(30)
                .isStudent(false)
                .build());
        persons.add(Person.builder()
                .id(++personId)
                .name("Oscar")
                .age(40)
                .isStudent(false)
                .build());
        persons.add(Person.builder()
                .id(++personId)
                .name("Michael")
                .age(35)
                .isStudent(true)
                .build());
    }

    @Override
    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public long generatePersonId() {
        return ++personId;
    }
}
