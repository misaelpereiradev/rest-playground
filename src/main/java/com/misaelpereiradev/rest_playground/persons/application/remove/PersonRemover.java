package com.misaelpereiradev.rest_playground.persons.application.remove;

import com.misaelpereiradev.rest_playground.persons.domain.exception.PersonNotFoundException;
import com.misaelpereiradev.rest_playground.persons.domain.model.Person;
import com.misaelpereiradev.rest_playground.persons.domain.port.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonRemover {

    private final PersonRepository repository;

    public void delete(long id) {
        Person currentPerson = repository.getPersons().stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElseThrow(() -> new PersonNotFoundException(String.format("Person with id %d not found", id)));

        repository.getPersons().remove(currentPerson);
    }
}
