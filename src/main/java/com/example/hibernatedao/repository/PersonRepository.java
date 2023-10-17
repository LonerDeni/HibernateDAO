package com.example.hibernatedao.repository;

import com.example.hibernatedao.model.Customers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Customers getProduct(String name) {
        String hql = "from Customers where upper(name) = upper(:username)";
        TypedQuery<Customers> query = entityManager.createQuery(hql, Customers.class);
        return query.setParameter("username", name).getResultList()
                .stream().findFirst().orElse(null);
    }
}