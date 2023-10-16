package com.example.hibernatedao.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "netology")
public class Orders {
    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    //@ManyToOne()
////    @JoinColumn(name="customer_id", nullable = false)
    //private Customers customers;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "product_name")
    private String productName;

    private int amount;

//    @ManyToMany
//    private List<Customers> customers;
}
