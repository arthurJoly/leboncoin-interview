package com.leboncoin.leboncoininterview.controllers;

import com.leboncoin.leboncoininterview.model.Request;
import com.leboncoin.leboncoininterview.services.FizzBuzzService;
import com.leboncoin.leboncoininterview.services.RequestService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/requests")
public class RequestController {

    Logger logger = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private RequestService requestService;

    @GetMapping(value = "/max")
    @Operation(summary = "get the most frequent request")
    public ResponseEntity<Request> getMaxRequest() {
        logger.info("starting max request");
        return new ResponseEntity<>(requestService.getMaxRequest(), HttpStatus.OK);
    }
}
