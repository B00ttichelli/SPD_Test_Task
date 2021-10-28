package com.example.spd_test_task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UserDTO {

        private Long id;
        private String name;

        private String surname;

        private Date dateOfBirth;

        private String phoneNumber;

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private String password;

        private BigDecimal ordersSum;

        private BigDecimal cashSum;

        private BigDecimal cardSum;

}
