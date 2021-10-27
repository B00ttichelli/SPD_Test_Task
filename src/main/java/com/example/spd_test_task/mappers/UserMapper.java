package com.example.spd_test_task.mappers;

import com.example.spd_test_task.dto.UserDTO;
import com.example.spd_test_task.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO userToUserDto(User user);
    User userDtoToUser (UserDTO userDTO);
}
