package com.example.demo.dao;

import com.example.demo.entity.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface AuthDao extends GenericDao<Admin> {
    @Query("select a from Admin a where a.username = :username")
    Admin findByUsername(@Param("username") String username);

    default Admin create(Admin admin) {
        admin.setPassword(new BCryptPasswordEncoder().encode(admin.getPassword()));
        return save(admin);
    }

    default Admin auth(Admin admin) {
        Admin searchedAdmin = findByUsername(admin.getUsername());
        if (new BCryptPasswordEncoder().matches(admin.getPassword(), searchedAdmin.getPassword()))
            return searchedAdmin;

        return null;
    }
}
