package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean isValidDate(Admin admin) {
        return false;
    }

    @Override
    public String changePassword(String password) {
        return null;
    }

    @Override
    public Boolean isLogged() {
        long id = 1;
        Admin admin = adminRepository.findById(id).get();
        return admin.isLogged();
    }

    @Override
    public Admin getAdmin() {
        long id= 1;
        Admin admin = adminRepository.findById(id).get();
        return admin;
    }

    @Override
    public Admin putFlag(Admin admin) {
        adminRepository.save(admin);
        return admin;
    }

    @Override
    public boolean isValid(String username, String password) {
        List<Admin> loginList = adminRepository.findAll();
        boolean isValid = false;
        for (Admin login : loginList) {
            if (login.getUsername().equals(username) && login.getPassword().equals(password)) {
                isValid = true;
            } else {
                isValid = false;
            }
        }
        return isValid;
    }

    }



