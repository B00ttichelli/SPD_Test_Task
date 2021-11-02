package com.example.spd_test_task.controller;

import com.example.spd_test_task.dto.UserDTO;
import com.example.spd_test_task.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity save(@Valid @RequestBody UserDTO user) {
        /*try {*/
            return ResponseEntity.ok(userService.save(user));
       /* } catch (Exception e) {

            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }*/
    }
    @GetMapping( "/{id}")  // for testing purposes
    public ResponseEntity get (  @PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(userService.finById(id));
        }catch (Exception e){
            return new ResponseEntity (e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }


@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(a->errors.add(a.getPropertyPath()+" : "+ a.getMessage()));
        return new ResponseEntity<List>(errors,HttpStatus.BAD_REQUEST);
}


}
