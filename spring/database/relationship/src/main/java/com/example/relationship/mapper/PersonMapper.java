package com.example.relationship.mapper;

import com.example.relationship.dto.PersonDto;
import com.example.relationship.dto.PersonRequest;
import com.example.relationship.entity.Detail;
import com.example.relationship.entity.Person;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Component
public class PersonMapper {

    public List<PersonDto> mapPersonDtoList(List<Person> list) {
        return list.stream()
                .map(this::mapPersonDto)
                .toList();
    }

    public PersonDto mapPersonDto(Person person) {
        PersonDto.Detail detail = Optional.ofNullable(person.getDetail())
                .map(this::mapDetail)
                .orElse(new PersonDto.Detail());
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .detail(detail)
                .build();
    }

    public Person mapPerson(PersonRequest personRequest) {
        // optionalValue.map(v::someMethod()).orElse(null)
        Detail detail = Optional.ofNullable(personRequest.getDetail())
                .map(this::mapDetail)
                .orElse(new Detail());
        return Person.builder()
                .name(personRequest.getName())
                .detail(detail)
                .build();
    }

    private PersonDto.Detail mapDetail(@NotNull Detail detail) {
        return PersonDto.Detail.builder()
                .id(detail.getId())
                .series(detail.getSeries())
                .number(detail.getNumber())
                .build();
    }

    private Detail mapDetail(@NotNull PersonRequest.Detail detail) {
        return Detail.builder()
                .series(detail.getSeries())
                .number(detail.getNumber())
                .build();
    }
}
