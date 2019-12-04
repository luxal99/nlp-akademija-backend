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
        sessionRepository.save(session);
        return "Uspesno ste se prijavili";
    }

    @Override
    public String delte(Long id) {
        sessionRepository.deleteById(id);
        return "Uspesno obrisana sesija";
    }

    @Override
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }
}
