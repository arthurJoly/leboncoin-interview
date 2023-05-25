package com.leboncoin.leboncoininterview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LeboncoinInterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeboncoinInterviewApplication.class, args);
    }

}
