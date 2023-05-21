package com.leboncoin.leboncoininterview.services;

import com.leboncoin.leboncoininterview.model.Request;

import java.util.List;

public interface RequestService {

    void addRequest(int limit, int divide1, int divide2, String replace1, String replace2);

    Request getMaxRequest();
}
