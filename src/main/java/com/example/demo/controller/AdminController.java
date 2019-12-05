package com.example.demo.controller;


import com.example.demo.entity.Client;
import com.example.demo.entity.Event;
import com.example.demo.entity.OnlineCheckIn;
import com.example.demo.entity.Product;
import com.example.demo.service.*;
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

    //region -- Client --
    @Autowired
    private ClientService clientService;

    @PostMapping("client/saveClient")
    public ResponseEntity saveClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }
    //endregion

    //region --OnlineCheckIn --

    @Autowired
    private OnlineCheckInService onlineCheckInService;

    @PostMapping("checkin/saveCheckIn")
    public ResponseEntity saveCheckIn(@RequestBody OnlineCheckIn onlineCheckIn) {
        return ResponseEntity.ok(onlineCheckInService.save(onlineCheckIn));
    }

    @GetMapping("checkin/getAll")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(onlineCheckInService.getAll());
    }

    //endregion

   //region --Login--
@Autowired
    private AdminService adminService;

    @GetMapping("/isLoginValid/{username}/{password}")
    public ResponseEntity isValid(@PathVariable String username,@PathVariable String password){
        return ResponseEntity.ok(adminService.isValid(username,password));
    }

    //endregion


}
