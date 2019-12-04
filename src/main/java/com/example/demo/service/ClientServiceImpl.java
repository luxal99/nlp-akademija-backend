package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Override
    public String save(Client client) {
        clientRepository.save(client);
        return "Uspesno sacuvan klijent";
    }

    @Override
    public String delete(Long id) {
        clientRepository.deleteById(id);
        return "Uspesno obrisan kurs";
    }

    @Override
    public String update(Client client) {
        clientRepository.save(client);
        return "Uspesno sacuvan klijent";
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
