package com.example.demo.service;

import com.example.demo.entity.Session;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public String save(Session session) {
        return null;
    }

    @Override
    public String delte(Long id) {
        return null;
    }

    @Override
    public List<Session> getAll() {
        return null;
    }
}
