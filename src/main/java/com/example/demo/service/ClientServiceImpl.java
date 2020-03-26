package com.example.demo.service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public Set<ClientDTO> getAll() {
        List<ClientDTO> clientList = new ArrayList<>();
        for (Client client :
                clientRepository.findAll()) {
            ClientDTO clientWithoudId = new ClientDTO();
            clientWithoudId.setName(client.getName());
            clientWithoudId.setLastname(client.getLastname());
            clientWithoudId.setMail(client.getMail());

            clientList.add(clientWithoudId);
        }

        Set<ClientDTO> clientSet = new HashSet<>(clientList);
        return clientSet;
    }
}
