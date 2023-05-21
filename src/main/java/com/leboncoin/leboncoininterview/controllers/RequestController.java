package com.leboncoin.leboncoininterview.controllers;

import com.leboncoin.leboncoininterview.model.Request;
import com.leboncoin.leboncoininterview.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "/max")
    public ResponseEntity<Request> getMaxRequest() {
        return new ResponseEntity<>(requestService.getMaxRequest(), HttpStatus.OK);
    }
}
