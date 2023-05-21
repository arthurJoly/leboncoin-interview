package com.leboncoin.leboncoininterview.repository;

import com.leboncoin.leboncoininterview.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, String> {

    @Query("SELECT r FROM Request r WHERE r.requestLimit = ?1 and r.divide1 = ?2 and r.divide2 = ?3 and r.replace1 = ?4 and r.replace2 = ?5")
    Request findRequestByParams(int requestLimit, int divide1, int divide2, String replace1, String replace2);

    @Query("SELECT r FROM Request r ORDER BY r.numberOfRequest DESC LIMIT 1")
    Request findMaxQuery();
}
