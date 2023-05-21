package com.leboncoin.leboncoininterview.controllers;

import com.leboncoin.leboncoininterview.model.Request;
import com.leboncoin.leboncoininterview.repository.RequestRepository;
import com.leboncoin.leboncoininterview.services.RequestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RequestControllerTests {

    @Autowired
    private RequestController requestController;

    @Autowired
    private RequestService requestService;


    @Test
    void testMaxRequest() {
        requestService.addRequest(10, 2, 3, "fizz", "buzz");
        requestService.addRequest(10, 2, 3, "fizz", "different");
        requestService.addRequest(10, 2, 3, "fizz", "buzz");

        ResponseEntity<Request> maxRequestResponse = requestController.getMaxRequest();
        assertNotNull(maxRequestResponse);
        Request maxRequest = maxRequestResponse.getBody();
        assertEquals(2, maxRequest.getNumberOfRequest());
        assertEquals(10, maxRequest.getRequestLimit());
        assertEquals(2, maxRequest.getDivide1());
        assertEquals(3, maxRequest.getDivide2());
        assertEquals("fizz", maxRequest.getReplace1());
        assertEquals("buzz", maxRequest.getReplace2());

    }
}
