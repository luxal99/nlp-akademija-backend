package com.example.demo.controller;

import com.example.demo.dao.ClientCustomDao;
import com.example.demo.dao.ClientDao;
import com.example.demo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController extends GenericController<Client> {

    @Autowired
    private ClientCustomDao customDao;

    @Autowired
    private ClientDao clientDao;

    @GetMapping("all")
    public List<Client> clientSet() {
        return clientDao.findDistinctByMail();
    }

    @PostMapping("save")
    protected ResponseEntity<Client> save(@RequestBody Client client) {
        return ResponseEntity.ok(customDao.saveClient(client));
    }
}
