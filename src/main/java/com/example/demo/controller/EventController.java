package com.example.demo.controller;


import com.example.demo.entity.Event;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/event")
@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/getAllEvents")
    public ResponseEntity<List<Event>> getAllEvents(){
        return ResponseEntity.ok(eventService.getAll());
    }

    @PostMapping("/saveEvent")
    public ResponseEntity saveEvent(@RequestBody Event event){
        return ResponseEntity.ok(eventService.save(event));
    }

}
