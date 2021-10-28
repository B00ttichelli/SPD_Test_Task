package com.example.spd_test_task.controller;

import com.example.spd_test_task.service.StatisticService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @RequestMapping("/stat")
    ResponseEntity getStat(){
        try {
            return ResponseEntity.ok(statisticService.get());
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
