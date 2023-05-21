package com.leboncoin.leboncoininterview.controllers;

import com.leboncoin.leboncoininterview.services.FizzBuzzService;
import com.leboncoin.leboncoininterview.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping
    public ResponseEntity<String> getFizzBuzz(@RequestParam int limit, @RequestParam int divide1, @RequestParam int divide2, @RequestParam String replace1, @RequestParam String replace2) {
        requestService.addRequest(limit, divide1, divide2, replace1, replace2);
        return new ResponseEntity<>(fizzBuzzService.getFizzBuzz(limit, divide1, divide2, replace1, replace2), HttpStatus.OK);
    }
}
