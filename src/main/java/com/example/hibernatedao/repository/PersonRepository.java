package com.example.hibernatedao.repository;

import com.example.hibernatedao.model.Customers;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

//    public Customers getProduct(String name) {
//        Customers tt = entityManager.find(Customers.class,1);
//        return tt;
//    }
    public List<Customers> getProduct(String name) {
        String hql = "FROM Customers JOIN Orders ON Customers.id = Orders .customerId where upper(Customers.name) = upper(:name)";
        TypedQuery<Customers> queryPersons = entityManager
                .createQuery(hql, Customers.class);
        return queryPersons.setParameter("name",name).getResultList();
    }
//    private static String read(String scriptFileName) {
//        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
//             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
//            return bufferedReader.lines().collect(Collectors.joining("\n"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}