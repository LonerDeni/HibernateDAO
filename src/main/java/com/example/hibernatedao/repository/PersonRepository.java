package com.example.hibernatedao.repository;

import com.example.hibernatedao.model.Persons;
import com.example.hibernatedao.repositories.PersonRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {

    private final PersonRepositories personRepositories;

    public PersonRepository(PersonRepositories personRepositories) {
        this.personRepositories = personRepositories;
    }

    public List<Persons> getPersonsByCity(String city) {
        return personRepositories.findByCityOfLiving(city);
    }
    public List<Persons> getPersonsAge(int age) {
        return personRepositories.findByAgeLessThanOrderByAgeDesc(age);
    }
    public Optional<Persons> getPersonsFullName(String name, String surname) {
        return personRepositories.findByNameIgnoreCaseAndSurNameIgnoreCase(name,surname);
    }
}