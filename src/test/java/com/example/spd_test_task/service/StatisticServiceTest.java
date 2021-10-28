package com.example.spd_test_task.service;


import com.example.spd_test_task.dto.StatisticDto;
import com.example.spd_test_task.model.Product;
import com.example.spd_test_task.model.Purchases;
import com.example.spd_test_task.model.User;
import com.example.spd_test_task.repository.PurchasesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StatisticServiceTest {

    @Autowired
    private StatisticService statisticService;

    @MockBean
    private PurchasesRepository purchasesRepository;


    @Test
    public void getTest() {
        List<Purchases> purchases = dataProvider();
        when(purchasesRepository.findAllByDateOfPurchaseBetween(any(), any())).thenReturn(purchases);

        StatisticDto statisticDto = statisticService.get();

        Assertions.assertNotNull(statisticDto.getActive().get(0));
        Assertions.assertNotNull(statisticDto.getIdle().get(0));
        Assertions.assertNotNull(statisticDto.getNotActive().get(0));


    }


    public List<Purchases> dataProvider() {
        List<Purchases> purchases = new ArrayList<>();
        int counter = 0;
        while (counter < 1000) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -counter +1);
            User user = User.builder()
                    .name("name" + counter)
                    .surname("surname" + counter)
                    .phoneNumber("7777" + counter)
                    .password("testPass")
                    .cashSum(new BigDecimal(100 + counter))
                    .cardSum(new BigDecimal(100 + counter))
                    .ordersSum(new BigDecimal(200 + counter * 2))
                    .dateOfBirth(new Date(calendar.getTimeInMillis()))
                    .id((long) counter)
                    .build();
            Product product = Product.builder()
                    .Id((long) counter)
                    .productPrice(new BigDecimal(counter + 1000))
                    .productName("Product" + counter)
                    .build();
            Purchases purchase = Purchases.builder()
                    .dateOfPurchase(new Date(calendar.getTimeInMillis()))
                    .user(user)
                    .Product(product)
                    .type("CARD")
                    .build();
            purchases.add(purchase);
            counter++;


        }
        return purchases;
    }

}
