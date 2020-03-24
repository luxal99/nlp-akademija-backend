package com.example.demo.service;

import java.util.List;

public interface OnlineTrainingCheckinService {
    public List<com.example.demo.entity.OnlineTrainingCheckin> getAll();
    public String save(com.example.demo.entity.OnlineTrainingCheckin  onlineTrainingCheckin);
    public String deleteTrainingCheckin(Long id);
}
