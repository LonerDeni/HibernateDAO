package com.example.hibernatedao.controller;

import com.example.hibernatedao.model.Persons;
import com.example.hibernatedao.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class Controller {

    private final PersonRepository personRepository;

    public Controller(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getProduct(@RequestParam @RequestBody String city) {
        return personRepository.getPersonsByCity(city);
    }
}