package com.example.demo.dao;

import com.example.demo.entity.OnlineTrainingCheckin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TrainingDao extends GenericDao<OnlineTrainingCheckin> {
    @Query(value = "SELECT t from OnlineTrainingCheckin t where t.idClient.date = :date")
    List<OnlineTrainingCheckin> findAllByIdClientDate(@Param("date") String date);
}
