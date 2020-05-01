package com.example.demo.controller;

import com.example.demo.entity.Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController extends GenericController<Client> {

}
