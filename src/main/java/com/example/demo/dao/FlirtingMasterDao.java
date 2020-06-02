package com.example.demo.dao;

import com.example.demo.entity.FlirtingMaster;
import com.example.demo.entity.OnlineTrainingCheckin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlirtingMasterDao extends GenericDao<FlirtingMaster> {

    @Query(value = "SELECT t from FlirtingMaster t where t.idClient.date = :date")
    List<FlirtingMaster> findAllByIdClientDate(@Param("date") String date);
}
