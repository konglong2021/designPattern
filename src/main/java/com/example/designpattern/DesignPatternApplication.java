package com.example.designpattern;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DesignPatternApplication {


    public static void main(String[] args) {
        SpringApplication.run(DesignPatternApplication.class, args);
    }

}
