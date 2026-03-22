package com.misaelpereiradev.rest_playground.persons.application.update;

import com.misaelpereiradev.rest_playground.persons.domain.exception.PersonNotFoundException;
import com.misaelpereiradev.rest_playground.persons.domain.model.Person;
import com.misaelpereiradev.rest_playground.persons.domain.port.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonUpdater {

    private final PersonRepository repository;

    public void update(long id, Person updatedPerson) {
        updatedPerson.setId(id);
        repository.getPersons().stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .ifPresentOrElse(person -> person.update(updatedPerson), () -> {
                    throw new PersonNotFoundException(String.format("Person with id %d not found", id));
                });
    }
}
