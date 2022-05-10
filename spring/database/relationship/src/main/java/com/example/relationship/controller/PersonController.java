package com.example.relationship.controller;

import com.example.relationship.dto.PersonRequest;
import com.example.relationship.dto.PersonDto;
import com.example.relationship.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping(path = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(path = "/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto getPerson(@PathVariable(value = "id") Long id) {
        return personService.getPerson(id);
    }

    @PostMapping(path = "/persons")
    public ResponseEntity<Void> createPerson(@RequestBody PersonRequest personRequest) {
        personService.createPerson(personRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/persons/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable(value = "id") Long id,
                                             @RequestBody PersonRequest person) {
        personService.updatePerson(id, person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable(value = "id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/health")
    public ResponseEntity<Void> health() {
        return ResponseEntity.ok().build();
    }
}
