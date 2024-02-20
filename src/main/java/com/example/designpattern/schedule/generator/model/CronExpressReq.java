package com.example.designpattern.schedule.generator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CronExpressReq {
    private Long minutes;
    private Long hourly;
    private String days;
    private Long dayNo;
    private Long month;
    private Long weekNo;
    private String dayName;
    private String monthName;
    private String time;
    private String type;

}
