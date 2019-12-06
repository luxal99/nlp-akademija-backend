package com.example.demo.service;

import com.example.demo.entity.Admin;

public interface AdminService {
    public boolean isValidDate(Admin admin);
    public String changePassword(String password);
    public Boolean isLogged();
    public Admin getAdmin();
    public Admin putFlag(Admin admin);
    public  boolean isValid(String username,String password);
}
