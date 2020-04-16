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
    private Map<String, Client> clients;
    private Map<String, >

    public ClientServiceImpl(){
        clients = new HashMap<>();
        id = 0;
        Client client = new Client();
        Login login = new Login();
        login.setUsername("Ruben");
        login.setPassword("fonas");
        client.setLogin(login);
        client.setFirstName("Ruben");
        login.setClient(client);
        save(client);
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
        if(checkUsername(client)){
            return null;
        }
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

    private boolean checkUsername(Client client){
        for (Client c : getAll()) {
            if(client.getLogin().getUsername().equals(c.getLogin().getUsername())){
                return false;
            }
        }
        return true;
    }
}
