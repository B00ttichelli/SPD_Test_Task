package com.example.spd_test_task.service.impl;

import com.example.spd_test_task.dto.StatisticDto;
import com.example.spd_test_task.dto.UserDTO;
import com.example.spd_test_task.mappers.UserMapper;
import com.example.spd_test_task.model.Purchases;
import com.example.spd_test_task.repository.PurchasesRepository;
import com.example.spd_test_task.service.StatisticService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Month;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final PurchasesRepository purchasesRepository;
    private final UserMapper userMapper;


    @Override
    public StatisticDto get() {
        Calendar calendar = Calendar.getInstance();

        Date beginDate = new Date(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE,-3);
        Date endDate = new Date(calendar.getTimeInMillis());

        /*List<Purchases> activePurchasesList = purchasesRepository.findAllByDateRange(beginDate, endDate);*/


        List<Purchases> activePurchasesList = purchasesRepository.findAllByDateOfPurchaseBetween(endDate,beginDate);

        List<UserDTO> activeUsers = new ArrayList<>(activePurchasesList
                .stream()
                .map(Purchases::getUser)
                .map(userMapper::userToUserDto)
                .collect(Collectors.toSet()));
        Map<Month, List<UserDTO>> active = new HashMap<>();
        active.put(Month.JANUARY, activeUsers);
        List<Map<Month, List<UserDTO>>> activeList = new ArrayList<>();
        activeList.add(active);
        return StatisticDto.builder()
                .active(activeList)
                .notActive(activeList)
                .idle(activeList)
                .build();

    }
}
