package com.example.spd_test_task.service;


import com.example.spd_test_task.dto.UserDTO;
import com.example.spd_test_task.mappers.UserMapper;
import com.example.spd_test_task.model.User;
import com.example.spd_test_task.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {


    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSave() {
        String testPassword = "testPassword";
        UserDTO userDTO = UserDTO.builder()
                .id(1L)
                .dateOfBirth(new Date(Calendar.getInstance().getTimeInMillis()))
                .name("Ivan")
                .name("Zalpuan")
                .password(testPassword)
                .phoneNumber("77-777-777-777")
                .cardSum(new BigDecimal(0))
                .cashSum(new BigDecimal(0))
                .ordersSum(new BigDecimal(0))
                .build();

        System.out.println(userMapper.userDtoToUser(userDTO));
        when(userRepository.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());

        UserDTO save = userService.save(userDTO);
        Assertions.assertNotNull(save);
        Assertions.assertNotEquals(save.getPassword(), testPassword);

    }
}
