package com.example.demo.service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.entity.Client;

import java.util.List;
import java.util.Set;

public interface ClientService  {

    public Client save(Client client);
    public String delete(Long id);
    public String update(Client client);
    public Set<ClientDTO> getAll();
}
