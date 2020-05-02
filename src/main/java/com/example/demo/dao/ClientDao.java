package com.example.demo.dao;

import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface ClientDao extends GenericDao<Client> {
    @Query("SELECT DISTINCT new Client(name,lastname,mail) FROM Client ")
    List<Client> findDistinctByMail();

}
