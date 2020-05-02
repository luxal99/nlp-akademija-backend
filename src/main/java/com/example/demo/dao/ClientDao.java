package com.example.demo.dao;

import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.Query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ClientDao extends GenericDao<Client> {
    @Query("SELECT DISTINCT new Client(name,lastname,mail) FROM Client ")
    List<Client> findDistinctByMail();

    default Client create(Client client) {
        client.setDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        save(client);
        return client;
    }
}
