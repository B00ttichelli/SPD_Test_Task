package com.example.spd_test_task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

        private Long id;

        private String name;

        private String surname;

        private Date dateOfBirth;
        
        private String phoneNumber;



}
