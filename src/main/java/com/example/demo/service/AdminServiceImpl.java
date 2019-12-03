package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
}
