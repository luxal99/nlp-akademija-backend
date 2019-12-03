package com.example.demo.service;

import com.example.demo.entity.Session;

import java.util.List;

public interface SessionService {
    public String save(Session session);
    public String delte(Long id);
    public List<Session> getAll();
}
