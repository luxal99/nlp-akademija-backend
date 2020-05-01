package com.example.demo.dao;

import com.example.demo.entity.OnlineTrainingCheckin;

import java.util.Date;
import java.util.List;

public interface TrainingCustomDao {
    public List<OnlineTrainingCheckin> findClientByDate(Date date);
}
