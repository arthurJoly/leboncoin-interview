package com.leboncoin.leboncoininterview.services;

import com.leboncoin.leboncoininterview.model.Request;
import com.leboncoin.leboncoininterview.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Override
    public void addRequest(int limit, int divide1, int divide2, String replace1, String replace2) {
        Request request = requestRepository.findRequestByParams(limit, divide1, divide2, replace1, replace2);
        if(request == null) {
            request = new Request(limit, divide1, divide2, replace1, replace2);
        }
        request.setNumberOfRequest(request.getNumberOfRequest() + 1);
        requestRepository.save(request);
    }

    @Override
    public Request getMaxRequest() {
        return requestRepository.findMaxQuery();
    }
}
