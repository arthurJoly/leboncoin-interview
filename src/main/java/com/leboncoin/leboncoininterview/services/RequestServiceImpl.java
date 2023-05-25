package com.leboncoin.leboncoininterview.services;

import com.leboncoin.leboncoininterview.controllers.RequestController;
import com.leboncoin.leboncoininterview.model.Request;
import com.leboncoin.leboncoininterview.repository.RequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    Logger logger = LoggerFactory.getLogger(RequestService.class);

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public void addRequest(int limit, int divide1, int divide2, String replace1, String replace2) {
        Request request = requestRepository.findRequestByParams(limit, divide1, divide2, replace1, replace2);
        if(request == null) {
            request = new Request(limit, divide1, divide2, replace1, replace2);
        }
        request.setNumberOfRequest(request.getNumberOfRequest() + 1);
        logger.info("adding request limit {}", request);
        requestRepository.save(request);
    }

    @Override
    public Request getMaxRequest() {
        logger.info("getting max request");
        return requestRepository.findMaxQuery();
    }
}
