package com.misaelpereiradev.rest_playground.persons.infrastructure.rest;

import com.misaelpereiradev.openapi.api.PersonsApi;
import com.misaelpereiradev.openapi.model.PersonDto;
import com.misaelpereiradev.rest_playground.persons.application.create.PersonCreator;
import com.misaelpereiradev.rest_playground.persons.application.remove.PersonRemover;
import com.misaelpereiradev.rest_playground.persons.application.retrieve.PersonRetriever;
import com.misaelpereiradev.rest_playground.persons.application.update.PersonUpdater;
import com.misaelpereiradev.rest_playground.persons.infrastructure.rest.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class PersonRestAdapter implements PersonsApi {

    private final PersonMapper mapper;
    private final PersonCreator creator;
    private final PersonUpdater updater;
    private final PersonRetriever retriever;
    private final PersonRemover remover;

    @Override
    public ResponseEntity<Long> createPerson(PersonDto person) {
        return Stream.of(person)
                .map(mapper::toDomain)
                .map(creator::create)
                .map(id -> new ResponseEntity<>(id, HttpStatus.CREATED))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public ResponseEntity<Void> deletePerson(Long personId) {
        remover.delete(personId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<PersonDto> getPerson(Long personId) {
        return Stream.of(personId)
                .map(retriever::getById)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public ResponseEntity<List<PersonDto>> getPersons() {
        return Stream.of(retriever.getAll())
                .map(mapper::toDtoList)
                .map(ResponseEntity::ok)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public ResponseEntity<Void> updatePerson(Long personId, PersonDto person) {
        var personDomain = mapper.toDomain(person);
        updater.update(personId, personDomain);
        return ResponseEntity.noContent().build();
    }
}
