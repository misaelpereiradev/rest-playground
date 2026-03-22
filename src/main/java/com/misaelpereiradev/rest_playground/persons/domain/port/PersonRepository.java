package com.misaelpereiradev.rest_playground.persons.domain.port;

import com.misaelpereiradev.rest_playground.persons.domain.model.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> getPersons();
    long generatePersonId();
}
