package com.example.spd_test_task.service;

import com.example.spd_test_task.dto.UserDTO;
import org.springframework.stereotype.Service;


public interface UserService {
    UserDTO save (UserDTO userDTO);

    UserDTO finById(Long id);
}
