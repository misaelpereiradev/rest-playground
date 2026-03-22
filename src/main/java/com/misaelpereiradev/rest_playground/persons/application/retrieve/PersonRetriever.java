package com.misaelpereiradev.rest_playground.persons.application.retrieve;

import com.misaelpereiradev.rest_playground.persons.domain.exception.PersonNotFoundException;
import com.misaelpereiradev.rest_playground.persons.domain.model.Person;
import com.misaelpereiradev.rest_playground.persons.domain.port.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonRetriever {

    private final PersonRepository repository;

    public List<Person> getAll() {
        return repository.getPersons();
    }

    public Person getById(long id) {
        return repository.getPersons().stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElseThrow(() -> new PersonNotFoundException(String.format("Person with id %d not found", id)));
    }
}
