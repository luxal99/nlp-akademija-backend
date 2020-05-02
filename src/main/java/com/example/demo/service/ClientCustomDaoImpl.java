package com.example.demo.service;

import com.example.demo.dao.ClientCustomDao;
import com.example.demo.dao.ClientDao;
import com.example.demo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ClientCustomDaoImpl implements ClientCustomDao {

    @Autowired
    private ClientDao clientGenericDao;

    @Override
    public Client saveClient(Client client) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        client.setDate(date);
        clientGenericDao.save(client);
        return client;
    }
}
