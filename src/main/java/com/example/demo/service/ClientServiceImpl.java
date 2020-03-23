package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Override
        public Client save(Client client) {
        clientRepository.save(client);
        return client;
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
    public Set<Client> getAll() {
        Set<Client> clientSet = new HashSet<>(clientRepository.findAll());

        return clientSet;
    }
}
