package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.entity.OnlineTrainingCheckin;

import java.util.Date;
import java.util.List;

public interface OnlineTrainingCheckinService {
    public List<com.example.demo.entity.OnlineTrainingCheckin> getAll();
    public String save(com.example.demo.entity.OnlineTrainingCheckin  onlineTrainingCheckin);
    public String deleteTrainingCheckin(Long id);
    public List<OnlineTrainingCheckin> findClienByDate(Date date);
}
