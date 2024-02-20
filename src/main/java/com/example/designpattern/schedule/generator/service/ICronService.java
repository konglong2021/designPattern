package com.example.designpattern.schedule.generator.service;

public interface ICronService {
    String cronMinutesExp(Long minutes);
    String cronHourlyExp(Long hourly);
    String cronOtherTimeExp(String time);
    String cronDailyExp(String timeVal);
    String cronEveryWeekDayExp(String weeklyTime);
    String cronWeeklyExp(String weeklyTime , String days);
    String cronMonthlyExp(Long day,Long month,String time);
    String cronMonthlyByWeekExp(Long month,Long weekNo,String time,String dayName);
    String cronYearlyExp(String monthName,Long dayNo,String time);
    String cronYearlyByMonthExp(String monthName,Long weekNo,String dayName,String time);
}
