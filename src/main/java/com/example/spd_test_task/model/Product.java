package com.example.spd_test_task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapping;

import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;


    private String productName;


    private BigDecimal productPrice;



}
