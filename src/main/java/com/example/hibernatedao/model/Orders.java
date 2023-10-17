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

    @Column(name = "product_name")
    private String productName;

    private int amount;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customers customers;
}
