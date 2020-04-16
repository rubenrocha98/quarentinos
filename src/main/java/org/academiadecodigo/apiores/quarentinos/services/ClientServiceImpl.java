package org.academiadecodigo.apiores.quarentinos.services;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;
import org.academiadecodigo.apiores.quarentinos.persistence.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements  ClientService {

    private Integer id;
    private Map<Integer, Client> clients;
    private AuthService authService;



    public ClientServiceImpl(){
        clients = new HashMap<>();
        id = 0;

    }

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;

    }

    @Override
    public Client get(Integer id) {
        return clients.get(id);
    }


    @Override
    public List<Client> getAll() {
        return new ArrayList<>(clients.values());
    }

    @Override
    public Client save(Client client) {
        Login login = authService.addLogin(client.getLogin());
        if(login== null){
            return null;
        }

        id++;
        client.setId(id);
        login.setClient(client);
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
