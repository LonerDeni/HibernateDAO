package com.example.hibernatedao.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "netology")
public class Customers {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Column(name = "surname")
    private String surName;

    private int age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany
    private List<Customers> orders;
}
