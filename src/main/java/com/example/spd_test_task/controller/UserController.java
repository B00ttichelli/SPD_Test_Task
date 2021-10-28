package com.example.spd_test_task.controller;

import com.example.spd_test_task.dto.UserDTO;
import com.example.spd_test_task.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity save(@RequestBody UserDTO user) {
        try {
            return ResponseEntity.ok(userService.save(user));
        } catch (Exception e) {

            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping( "/{id}")  // for testing purposes
    public ResponseEntity<UserDTO> get (@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(userService.finById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


/*   json example for testing {
        "name": "test",
            "surname": "test",
            "dateOfBirth": "2013-10-21T13:28:06.419Z",
            "phoneNumber": "223221214412",
            "password": "test"
    }*/


}
