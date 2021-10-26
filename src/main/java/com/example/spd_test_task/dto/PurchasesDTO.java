package com.example.spd_test_task.dto;

import com.example.spd_test_task.model.Product;
import com.example.spd_test_task.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchasesDTO {

    private Long id;

    private User user;

    private Product product;

    private Date dateOfPurchase;
}
