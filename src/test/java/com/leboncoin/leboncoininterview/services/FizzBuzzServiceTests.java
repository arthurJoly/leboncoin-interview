package com.leboncoin.leboncoininterview.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzServiceTests {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Test
    void testFizzBuzzBaseCase() {
        assertEquals("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz", fizzBuzzService.getFizzBuzz(15, 3, 5, "fizz", "buzz"));
    }

    @Test
    void testFizzBuzzCantDivideBy0() {
        assertEquals("1,2,3,4,buzz,6,7,8,9,buzz,11,12,13,14,buzz", fizzBuzzService.getFizzBuzz(15, 0, 5, "fizz", "buzz"));
    }

    @Test
    void testFizzBuzzBothBy0() {
        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", fizzBuzzService.getFizzBuzz(15, 0, 0, "fizz", "buzz"));
    }
}

