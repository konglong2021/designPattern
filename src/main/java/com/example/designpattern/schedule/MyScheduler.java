package com.example.designpattern.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MyScheduler {

    @Scheduled(cron = "0 0/1 * 1/1 * ? ")
    public void firstScheduler() {
        System.out.println("hello world! " + new Date());
    }
}
