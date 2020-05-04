package com.example.demo.controller;

import com.example.demo.entity.Event;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController extends GenericController<Event> {
}
