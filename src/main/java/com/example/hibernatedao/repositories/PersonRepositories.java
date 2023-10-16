package com.example.hibernatedao.repositories;

import com.example.hibernatedao.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepositories extends JpaRepository<Persons,Long> {
    List<Persons> findByCityOfLiving(String city);

    List<Persons> findByAgeLessThanOrderByAgeAsc(int age);
    Optional<Persons> findByNameIgnoreCaseAndSurNameIgnoreCase(String name, String surName);
}
