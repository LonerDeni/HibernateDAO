package com.example.hibernatedao.controller;

import com.example.hibernatedao.model.Customers;
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

    @GetMapping("/products/fetch-product")
    public List<Customers> getProduct(@RequestParam @RequestBody String name) {
        return personRepository.getProduct(name);
    }
}