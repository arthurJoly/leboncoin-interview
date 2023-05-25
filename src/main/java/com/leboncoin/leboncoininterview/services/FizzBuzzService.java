package com.leboncoin.leboncoininterview.services;

import org.springframework.cache.annotation.Cacheable;

public interface
FizzBuzzService {

    @Cacheable("fizzBuzz")
    String getFizzBuzz(int limit, int divide1, int divide2, String replace1, String replace2);
}
