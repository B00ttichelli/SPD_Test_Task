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
public class PurchasesDTO {

    private Long id;

    private UserDTO user;

    private ProductDTO product;

    private Date dateOfPurchase;
}
