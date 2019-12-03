package com.example.demo.service;

import com.example.demo.entity.Admin;

public interface AdminService {
    public boolean isValidDate(Admin admin);
    public String changePassword(String password);
}
