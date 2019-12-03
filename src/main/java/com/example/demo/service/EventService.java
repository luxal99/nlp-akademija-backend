package com.example.demo.service;

import com.example.demo.entity.Event;

import java.util.List;

public interface EventService {
    public String save(Event event);
    public String delete(Long id);
    public String update(Event event);
    public List<Event> getAll();
}
