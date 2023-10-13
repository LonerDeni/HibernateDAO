package com.example.hibernatedao.repository;

import com.example.hibernatedao.model.Persons;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Persons> getPersonsByCity(String city) {
        TypedQuery<Persons> queryPersons = entityManager
                .createQuery("from Persons where upper(cityOfLiving) = upper(:city)", Persons.class);
        List<Persons> persons = queryPersons.setParameter("city",city).getResultList();
        return persons;
    }
}