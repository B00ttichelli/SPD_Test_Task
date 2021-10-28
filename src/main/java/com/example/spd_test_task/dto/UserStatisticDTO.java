package com.example.spd_test_task.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserStatisticDTO {

    private String name;
    private String lastName;
    private String phoneNumber;
    private BigDecimal totalSpend;
    private BigDecimal cash;
    private BigDecimal card;
}
