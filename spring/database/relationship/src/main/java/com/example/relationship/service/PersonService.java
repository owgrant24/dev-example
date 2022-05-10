package com.example.relationship.service;

import com.example.relationship.dto.PersonRequest;
import com.example.relationship.dto.PersonDto;
import com.example.relationship.entity.Person;
import com.example.relationship.mapper.PersonMapper;
import com.example.relationship.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public List<PersonDto> getAllPersons() {
        List<Person> personList = personRepository.findAll();
        return personMapper.mapPersonDtoList(personList);
    }

    public PersonDto getPerson(long id) {
        Person person = personRepository.findById(id).orElseThrow();
        return personMapper.mapPersonDto(person);
    }

    public void createPerson(PersonRequest personRequest) {
        Person person = personMapper.mapPerson(personRequest);
        personRepository.save(person);
    }

    public void updatePerson(Long id, PersonRequest updatePersonRequest) {
        Person person = personRepository.findById(id).orElseThrow();
        person.setName(updatePersonRequest.getName());
        personRepository.save(person);
    }

    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }
}
