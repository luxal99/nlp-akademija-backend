package com.example.demo.dao;

import com.example.demo.dto.ClientDTO;
import com.example.demo.entity.Client;
import groovy.lang.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ClientCustomDaoImpl implements ClientCustomDao {

    @Autowired
    private ClientDao clientGenericDao;

    @Override
    public Set<ClientDTO> clientSet() {
        List<ClientDTO> clientList = new ArrayList<>();
        for (Client client :
                clientGenericDao.findAll()) {
            ClientDTO clientWithoudId = new ClientDTO();
            clientWithoudId.setName(client.getName());
            clientWithoudId.setLastname(client.getLastname());
            clientWithoudId.setMail(client.getMail());

            clientList.add(clientWithoudId);
        }
        System.out.println("True");
        Set<ClientDTO> clientSet = new HashSet<>(clientList);
        return clientSet;
    }

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
