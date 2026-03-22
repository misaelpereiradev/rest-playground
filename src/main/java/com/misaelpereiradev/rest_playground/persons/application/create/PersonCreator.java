package com.misaelpereiradev.rest_playground.persons.application.create;

import com.misaelpereiradev.rest_playground.persons.domain.model.Person;
import com.misaelpereiradev.rest_playground.persons.domain.port.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonCreator {

    private final PersonRepository repository;

    public long create(Person newPerson) {
        newPerson.setId(repository.generatePersonId());
        repository.getPersons().add(newPerson);
        return newPerson.getId();
    }
}
