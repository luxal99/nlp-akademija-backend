package com.example.demo.service;

import com.example.demo.entity.Event;
import com.example.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public String save(Event event) {
        eventRepository.save(event);
        return "Uspešno kreiran događaj";
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public String update(Event event) {
        return null;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }
}
