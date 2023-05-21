package com.leboncoin.leboncoininterview.services;

import com.leboncoin.leboncoininterview.model.Request;
import com.leboncoin.leboncoininterview.repository.RequestRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RequestServiceTests {

    @Autowired
    private RequestService requestService;

    @Autowired
    private RequestRepository requestRepository;

    @Test
    void testAddingRequests() {
        requestService.addRequest(10, 3, 5, "fizz", "buzz");
        requestService.addRequest(10, 3, 5, "fizz", "buzz");
        requestService.addRequest(10, 3, 5, "fizz", "test");

        List<Request> requests = requestRepository.findAll();
        assertNotNull(requests);
        assertEquals(2, requests.size());

        Request maxRequest = requestService.getMaxRequest();
        assertEquals(2, maxRequest.getNumberOfRequest());
        assertEquals(10, maxRequest.getRequestLimit());
        assertEquals(3, maxRequest.getDivide1());
        assertEquals(5, maxRequest.getDivide2());
        assertEquals("fizz", maxRequest.getReplace1());
        assertEquals("buzz", maxRequest.getReplace2());

    }
}
