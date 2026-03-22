package com.misaelpereiradev.rest_playground.persons.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private Long id;
    private String name;
    private Integer age;
    private Boolean isStudent;

    public void update(Person person) {
        setId(person.getId());
        setName(person.getName());
        setAge(person.getAge());
        setIsStudent(person.getIsStudent());
    }
}
