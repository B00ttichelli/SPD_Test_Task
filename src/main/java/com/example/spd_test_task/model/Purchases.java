package com.example.spd_test_task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product Product;

    private String type;

    @Basic
    private Date dateOfPurchase;

}
