package com.example.demo.controller;

import com.example.demo.dao.AuthDao;
import com.example.demo.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthDao authDao;

    @PostMapping("create")
    public ResponseEntity<Admin> create(@RequestBody Admin admin) {
        return ResponseEntity.ok(authDao.create(admin));
    }

    @PostMapping("check")
    public Admin auth(@RequestBody Admin admin) {
        return authDao.auth(admin);
    }
}
