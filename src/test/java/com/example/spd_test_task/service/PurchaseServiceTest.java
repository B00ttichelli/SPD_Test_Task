package com.example.spd_test_task.service;

import com.example.spd_test_task.dto.ProductDTO;
import com.example.spd_test_task.dto.PurchasesDTO;
import com.example.spd_test_task.dto.UserDTO;
import com.example.spd_test_task.enums.PaymentType;
import com.example.spd_test_task.model.Product;
import com.example.spd_test_task.model.Purchases;
import com.example.spd_test_task.model.User;
import com.example.spd_test_task.repository.ProductRepository;
import com.example.spd_test_task.repository.PurchasesRepository;
import com.example.spd_test_task.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PurchaseServiceTest {


    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
     private PurchasesRepository purchasesRepository;

    @Autowired
    private PurchasesService purchasesService;





    @Test
    public void testSave(){



        User user = User.builder()
                .id(1L)
                .name("Vasya")
                .dateOfBirth(new Date(Calendar.getInstance().getTimeInMillis()))
                .cardSum(new BigDecimal(1000))
                .cashSum(new BigDecimal(1000))
                .ordersSum(new BigDecimal(2000))
                .password("123456")
                .phoneNumber("77777777")
                .surname("Pupkin")
                .build();
        Product product = Product.builder()
                .Id(1L)
                .productName("Nokia 8800")
                .productPrice(new BigDecimal(1000))
                .build();
        ProductDTO productDTO = ProductDTO.builder()
                .Id(1L)
                .productName("Nokia 8800")
                .productPrice(new BigDecimal(1000))
                .build();

        UserDTO userDTO = UserDTO.builder()
                .id(1L)
                .name("Vasya")
                .dateOfBirth(new Date(Calendar.getInstance().getTimeInMillis()))
                .cardSum(new BigDecimal(1000))
                .cashSum(new BigDecimal(1000))
                .ordersSum(new BigDecimal(2000))
                .password("123456")
                .phoneNumber("77777777")
                .surname("Pupkin")
                .build();

        PurchasesDTO purchasesDTO = PurchasesDTO.builder()
                .product(productDTO)
                .user(userDTO)
                .dateOfPurchase(new Date(Calendar.getInstance().getTimeInMillis()))
                .type(PaymentType.CARD)
                .id(1L)
                .build();


        doReturn(user).when(userRepository).getById(any(Long.class));
        when(productRepository.getById(any(Long.class))).thenReturn(product);
        when(userRepository.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());
        when(purchasesRepository.save(any(Purchases.class))).then(AdditionalAnswers.returnsFirstArg());

        PurchasesDTO save = purchasesService.save(purchasesDTO);
        Assertions.assertNotNull(save);
        Assertions.assertEquals(save.getUser().getName(), userDTO.getName());
        Assertions.assertEquals(save.getId(), userDTO.getId());
    }
/*
    */


}
