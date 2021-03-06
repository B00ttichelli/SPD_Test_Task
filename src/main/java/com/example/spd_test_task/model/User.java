package com.example.spd_test_task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
@Builder
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String surname;

        @Basic
        @Temporal(TemporalType.DATE)
        private Date dateOfBirth;


        private String phoneNumber;


        private String password;

        private BigDecimal ordersSum;

        private BigDecimal cashSum;

        private BigDecimal cardSum;
}
