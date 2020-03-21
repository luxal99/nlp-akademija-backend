package com.example.demo.service;

import com.example.demo.entity.OnlineCheckIn;

import java.util.List;

public interface OnlineCheckInService {
    public String save(OnlineCheckIn onlineCheckIn);
    public String delete(Long id);
    public String update(OnlineCheckIn onlineCheckIn);
    public List<OnlineCheckIn> getAll();
}
