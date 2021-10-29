package com.example.spd_test_task.dto;

import com.example.spd_test_task.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchasesDTO {

    @NotBlank
    @Positive
    private Long id;

    private UserDTO user;

    private ProductDTO product;

    private Date dateOfPurchase;

    private PaymentType type;
}
