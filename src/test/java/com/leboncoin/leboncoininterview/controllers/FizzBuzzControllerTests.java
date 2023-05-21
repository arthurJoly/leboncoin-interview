package com.leboncoin.leboncoininterview.controllers;

import com.leboncoin.leboncoininterview.model.Request;
import com.leboncoin.leboncoininterview.repository.RequestRepository;
import com.leboncoin.leboncoininterview.services.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FizzBuzzControllerTests {

    @Autowired
    private FizzBuzzController fizzBuzzController;

    @Autowired
    private RequestRepository requestRepository;

    @Test
    void testFizzBuzzBaseCase() {
        ResponseEntity<String> response = fizzBuzzController.getFizzBuzz(15, 3, 5, "fizz", "buzz");
        assertEquals(200, response.getStatusCode().value());
        assertEquals("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz", response.getBody());

        List<Request> requests = requestRepository.findAll();
        assertNotNull(requests);
        assertEquals(1, requests.size());

        Request maxRequest = requestRepository.findMaxQuery();
        assertEquals(1, maxRequest.getNumberOfRequest());
        assertEquals(15, maxRequest.getRequestLimit());
        assertEquals(3, maxRequest.getDivide1());
        assertEquals(5, maxRequest.getDivide2());
        assertEquals("fizz", maxRequest.getReplace1());
        assertEquals("buzz", maxRequest.getReplace2());
    }
}
