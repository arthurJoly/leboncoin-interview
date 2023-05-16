package com.leboncoin.leboncoininterview.controllers;

import com.leboncoin.leboncoininterview.services.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @RequestMapping(value = "/fizzBuzz")
    public ResponseEntity<String> getFizzBuzz(@RequestParam int limit, @RequestParam int divide1, @RequestParam int divide2, @RequestParam String replace1, @RequestParam String replace2) {
        return new ResponseEntity<>(fizzBuzzService.getFizzBuzz(limit, divide1, divide2, replace1, replace2), HttpStatus.OK);
    }
}
