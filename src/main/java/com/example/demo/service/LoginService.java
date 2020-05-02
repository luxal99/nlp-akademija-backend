package com.example.demo.service;

import com.example.demo.dao.AdminDao;
import com.example.demo.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService  {

    @Autowired
    private AdminDao adminDao;


    public Boolean auth(Admin admin) {
        return null;
    }


    public String update(Admin admin) {
        return null;
    }

    public  Admin create(Admin admin) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        adminDao.save(admin);
        return admin;
    }
}
