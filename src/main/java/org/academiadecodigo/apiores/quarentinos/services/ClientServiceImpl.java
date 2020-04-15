package org.academiadecodigo.apiores.quarentinos.services;

import org.academiadecodigo.apiores.quarentinos.persistence.dao.ClientDao;
import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;
import org.academiadecodigo.apiores.quarentinos.persistence.model.ClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements  ClientService {

    private Map<Integer, Client> clients;
    private ClientFactory clientFactory;

    public ClientServiceImpl(){
        clients = new HashMap<>();
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
    public Client save() {

    }

    @Override
    public Client update(Client client) {
        return null;
    }


    @Override
    public void delete(Integer id) throws Exception {

        Client client = clientDao.find(id);

        if(client == null){
            throw new Exception();
        }

        clientDao.delete(id);

    }
}
