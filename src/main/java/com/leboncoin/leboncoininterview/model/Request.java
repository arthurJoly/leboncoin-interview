package com.leboncoin.leboncoininterview.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Request {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int requestLimit;

    private int divide1;

    private int divide2;

    private String replace1;

    private String replace2;

    private int numberOfRequest;

    public Request(int requestLimit, int divide1, int divide2, String replace1, String replace2) {
        this.numberOfRequest = 0;
        this.requestLimit = requestLimit;
        this.divide1 = divide1;
        this.divide2 = divide2;
        this.replace1 = replace1;
        this.replace2 = replace2;
    }

    public Request() {

    }
}
