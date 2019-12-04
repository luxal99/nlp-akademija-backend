package com.example.demo.service;

import com.example.demo.entity.Client;

import java.util.List;

public interface ClientService  {

    public String save(Client client);
    public String delete(Long id);
    public String update(Client client);
    public List<Client> getAll();
}
