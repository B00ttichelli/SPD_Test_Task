package com.example.spd_test_task.service.impl;

import com.example.spd_test_task.dto.StatisticDto;
import com.example.spd_test_task.dto.UserDTO;
import com.example.spd_test_task.dto.UserStatisticDTO;
import com.example.spd_test_task.enums.PaymentType;
import com.example.spd_test_task.mappers.UserMapper;
import com.example.spd_test_task.model.Purchases;
import com.example.spd_test_task.repository.PurchasesRepository;
import com.example.spd_test_task.service.StatisticService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final PurchasesRepository purchasesRepository;
    private final UserMapper userMapper;


    @Override
    @Transactional
    public StatisticDto get() {


        return StatisticDto.builder()
                .active(parseUsersByActivity(0, -3))
                .idle(parseUsersByActivity(-3, 20))
                .notActive(parseUsersByActivity(-20, -90))
                .build();

    }

    //todo
    //Осилил вроде )) но понимаю что можно сильно упрсотить особено посредством запросов в базу,
    // но если копатса то вовремя  не здам (короче за мной долг)
    List<Map<Month, List<UserStatisticDTO>>> parseUsersByActivity(int daysStart, int daysEnd) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, daysStart); //0
        Date beginDate = new Date(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, daysEnd); //-3
        Date endDate = new Date(calendar.getTimeInMillis());

        List<Purchases> activePurchasesList = purchasesRepository.findAllByDateOfPurchaseBetween(endDate, beginDate);

        List<UserDTO> activeUsers = new ArrayList<>(activePurchasesList
                .stream()
                .map(Purchases::getUser)
                .map(userMapper::userToUserDto)
                .collect(Collectors.toSet()));
        Map<Month, List<UserStatisticDTO>> active = new HashMap<>();
        List<UserStatisticDTO> statisticDtoList = new ArrayList<>();

        for (Purchases purchase : activePurchasesList
        ) {
            Month month = purchase.getDateOfPurchase().toLocalDate().getMonth();
            if (!active.containsKey(month)) {
                active.put(month, new ArrayList<>());
            }

        }

        for (UserDTO user : activeUsers
        ) {
            List<Purchases> allByDateOfPurchaseBetweenAndUserAndId = activePurchasesList
                    .stream()
                    .filter(a -> a.getUser().getId().equals(user.getId()))
                    .collect(Collectors.toList());

            for (Month month : active.keySet()
            ) {
                UserStatisticDTO userStat = UserStatisticDTO.builder()
                        .name(user.getName())
                        .lastName(user.getSurname())
                        .phoneNumber(user.getPhoneNumber())
                        .card(new BigDecimal(0))
                        .cash(new BigDecimal(0))
                        .totalSpend(new BigDecimal(0))
                        .build();


                for (Purchases purchase : allByDateOfPurchaseBetweenAndUserAndId
                ) {
                    if (purchase.getDateOfPurchase().toLocalDate().getMonth().equals(month)) {
                        if (purchase.getType().equals(PaymentType.CARD.toString())) {
                            BigDecimal productPrice = purchase.getProduct().getProductPrice();
                            userStat.setCard(userStat.getCard().add(productPrice));
                            userStat.setTotalSpend(userStat.getTotalSpend().add(productPrice));
                        } else {
                            userStat.setCash(userStat.getCash().add(purchase.getProduct().getProductPrice()));
                            userStat.setTotalSpend(userStat.getTotalSpend().add(purchase.getProduct().getProductPrice()));
                        }
                    }


                }

                if (userStat.getTotalSpend().intValue() > 0) {
                    active.get(month).add(userStat);

                }

            }
        }

        List<Map<Month, List<UserStatisticDTO>>> activeList = new ArrayList<>();
        activeList.add(active);
        return activeList;
    }



}
