package com.example.relationship.mapper;

import com.example.relationship.dto.PersonDto;
import com.example.relationship.dto.PersonRequest;
import com.example.relationship.entity.Car;
import com.example.relationship.entity.Detail;
import com.example.relationship.entity.Person;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Collections;
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
                .map(this::mapDetailDto)
                .orElse(new PersonDto.Detail());
        List<PersonDto.Car> cars = Optional.ofNullable(person.getCars())
                .map(this::mapCarsDto)
                .orElse(Collections.emptyList());
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .detail(detail)
                .cars(cars)
                .build();
    }

    public Person mapPerson(PersonRequest personRequest) {
        // optionalValue.map(v::someMethod()).orElse(null)
        Detail detail = Optional.ofNullable(personRequest.getDetail())
                .map(this::mapDetail)
                .orElse(new Detail());
        List<Car> cars = Optional.ofNullable(personRequest.getCars())
                .map(this::mapCars)
                .orElse(Collections.emptyList());
        return Person.builder()
                .name(personRequest.getName())
                .detail(detail)
                .cars(cars)
                .build();
    }

    private PersonDto.Detail mapDetailDto(@NotNull Detail detail) {
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

    private List<PersonDto.Car> mapCarsDto(List<Car> cars) {
        return cars.stream()
                .map(this::mapCarDto)
                .toList();
    }

    private PersonDto.Car mapCarDto(Car car) {
        return PersonDto.Car.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .build();
    }

    private List<Car> mapCars(List<PersonRequest.Car> cars) {
        return cars.stream()
                .map(this::mapCar)
                .toList();
    }

    private Car mapCar(PersonRequest.Car car) {
        return Car.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .build();
    }
}
