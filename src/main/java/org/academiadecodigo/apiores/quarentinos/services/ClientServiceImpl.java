package org.academiadecodigo.apiores.quarentinos.services;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements  ClientService {

    private Integer id;
    private Map<Integer, Client> clients;

    public ClientServiceImpl(){
        clients = new HashMap<>();
        id = 0;
    }


    @Override
    public Client get(Integer id) {
        return clients.get(id);
    }


    @Override
    public List<Client> getAll() {
        return clients.values().stream()
                .collect(Collectors.toList());
    }

    @Override
    public Client save(Client client) {
        id++;
        client.setId(id);
        clients.put(id, client);
        return client;
    }

    @Override
    public Client update(Client client) {
        clients.replace(client.getId(),client);
        return client;
    }


    @Override
    public void delete(Integer id) throws Exception {
       clients.remove(id);
    }
}
