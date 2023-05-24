package com.leboncoin.leboncoininterview.controllers;

import com.leboncoin.leboncoininterview.services.FizzBuzzService;
import com.leboncoin.leboncoininterview.services.RequestService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fizzBuzz")
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Autowired
    private RequestService requestService;

    @GetMapping
    @Operation(summary = "get fizz buzz string")
    public ResponseEntity<String> getFizzBuzz(@Parameter(description = "limit value for fizz buzz string") @RequestParam int limit,
                                              @Parameter(description = "if x divisible by divide1 then replace with replace1") @RequestParam int divide1,
                                              @Parameter(description = "if x divisible by divide2 then replace with replace2") @RequestParam int divide2,
                                              @Parameter(description = "if x divisible by divide1 then replace with replace1") @RequestParam String replace1,
                                              @Parameter(description = "if x divisible by divide2 then replace with replace2")@RequestParam String replace2) {
        requestService.addRequest(limit, divide1, divide2, replace1, replace2);
        return new ResponseEntity<>(fizzBuzzService.getFizzBuzz(limit, divide1, divide2, replace1, replace2), HttpStatus.OK);
    }
}
