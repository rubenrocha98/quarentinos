package org.academiadecodigo.apiores.quarentinos.services;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;

import java.util.List;

public interface ClientService {

    Client get(Integer id);

    List<Client> getAll();

    Client save(Client client);

    Client update(Client client);

    void delete(Integer id) throws Exception;


}
