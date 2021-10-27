package com.example.spd_test_task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

        private Long id;
        private String name;

        private String surname;

        private Date dateOfBirth;
        
        private String phoneNumber;

        private String password;

}
