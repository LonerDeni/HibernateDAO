package com.example.hibernatedao.repositories;

import com.example.hibernatedao.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepositories extends JpaRepository<Persons,Long> {
    @Query(value = "select e from Persons e where upper(e.cityOfLiving) = upper(:city)")
    List<Persons> findByCityOfLiving(@Param("city") String city);

    @Query(value = "select e from Persons e where e.age < :age order by e.age asc")
    List<Persons> findByAgeLessThanOrderByAgeDesc(@Param("age") int age);

    @Query(value = "select e from Persons e where upper(e.name) = upper(:name) and upper(e.surName) = upper(:surname)")
    Optional<Persons> findByNameIgnoreCaseAndSurNameIgnoreCase(@Param("name") String name, @Param("surname") String surName);
}
