package com.example.demo.controller;


import com.example.demo.entity.Event;
import com.example.demo.entity.Product;
import com.example.demo.service.EventService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/event")
@RestController
@RequestMapping("/admin")
public class AdminController {

    //region --Event --
    @Autowired
    private EventService eventService;

    @GetMapping("event/getAllEvents")
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAll());
    }

    @PostMapping("event/saveEvent")
    public ResponseEntity saveEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.save(event));
    }

    @DeleteMapping("event/deleteEvent/{id}")
    public ResponseEntity deleteEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.delete(id));
    }

    @PutMapping("event/updateEvent")
    public ResponseEntity updateEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.update(event));

    }


    //endregion

    //region -- Product --

    @Autowired
    private ProductService productService;

    @PostMapping("product/saveProduct")
    public ResponseEntity saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("product/getAllProduct")
    public ResponseEntity getAllProduct() {
        return ResponseEntity.ok(productService.getALL());
    }

    @DeleteMapping("product/deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.delete(id));
    }

    @PutMapping("product/updateProduct")
    public ResponseEntity updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }

    //endregion
}
