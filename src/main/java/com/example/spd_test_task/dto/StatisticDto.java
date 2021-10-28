package com.example.spd_test_task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StatisticDto {


    private List<Map<Month, List<UserStatisticDTO>>> active;

    private List<Map<Month, List<UserStatisticDTO>>> idle;

    private List<Map<Month, List<UserStatisticDTO>>> notActive;


}
