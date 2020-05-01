package com.example.demo.dao;

import com.example.demo.dto.ClientDTO;
import com.example.demo.entity.Client;

import java.util.Set;

public interface ClientCustomDao {
    public Set<ClientDTO> clientSet();

    public Client saveClient(Client client);
}
