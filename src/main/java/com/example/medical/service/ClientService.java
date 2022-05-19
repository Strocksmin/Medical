package com.example.medical.service;

import com.example.medical.model.Client;
import com.example.medical.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }
}
