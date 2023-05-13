package com.leboncoin.leboncoininterview.services;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {
    @Override
    public String getFizzBuzz(int limit, int divide1, int divide2, String replace1, String replace2) {
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i <= limit; i++) {
            builder.append(getFizzBuzzString(i, divide1, divide2, replace1, replace2));
            if(i < limit) {
                builder.append(",");
            }
        }
        return builder.toString();
    }

    private String getFizzBuzzString(int current, int divide1, int divide2, String replace1, String replace2){
        if(isDivisible(current, divide1*divide2)) {
            return replace1 + replace2;
        } else if(isDivisible(current, divide1)) {
            return replace1;
        } else if(isDivisible(current, divide2)) {
            return replace2;
        }
        return Integer.toString(current);
    }

    private boolean isDivisible(int intToCheck, int divide) {
        if(divide == 0) {
            return false;
        }
        return intToCheck % divide == 0;
    }
}
