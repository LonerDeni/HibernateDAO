package com.example.hibernatedao.repository;

import com.example.hibernatedao.model.Customers;
import com.example.hibernatedao.model.Orders;
import org.aspectj.weaver.ast.Or;
import org.hibernate.query.Query;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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