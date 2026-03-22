package com.misaelpereiradev.rest_playground.persons.infrastructure.rest.mapper;

import com.misaelpereiradev.openapi.model.PersonDto;
import com.misaelpereiradev.rest_playground.persons.domain.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toDomain(PersonDto person);
    PersonDto toDto(Person person);
    List<Person> toDomainList(List<PersonDto> person);
    List<PersonDto> toDtoList(List<Person> person);
}
