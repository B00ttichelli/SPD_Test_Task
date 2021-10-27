package com.example.spd_test_task.controller;

import com.example.spd_test_task.dto.ProductDTO;
import com.example.spd_test_task.dto.PurchasesDTO;
import com.example.spd_test_task.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Calendar;

@RestController

public class TestController {
    //life hack to convert pojo in json
    @RequestMapping("/")
    public PurchasesDTO returnJson() {
        UserDTO userDTO = UserDTO.builder()
                .id(1L)
                .dateOfBirth(Calendar.getInstance().getTime())
                .name("TestName")
                .surname("TestSurname")
                .password("TestPassword")
                .phoneNumber("333-333-33").build();
        ProductDTO productDTO = ProductDTO.builder()
                .Id(1L)
                .productName("TestProductName")
                .productPrice(new BigDecimal(1000))
                .build();
        return PurchasesDTO.builder().
                dateOfPurchase(Calendar.getInstance().getTime())
                .user(userDTO)
                .product(productDTO)
                .build();

    }
/*  Generated JSON example
    {
        "id": null,
            "user": {
        "id": 1,
                "name": "TestName",
                "surname": "TestSurname",
                "dateOfBirth": "2021-10-27T15:24:33.252+00:00",
                "phoneNumber": "333-333-33",
                "password": "TestPassword"
    },
        "product": {
        "productName": "TestProductName",
                "productPrice": 1000,
                "id": 1
    },
        "dateOfPurchase": "2021-10-27T15:24:33.252+00:00"
    }*/

}
