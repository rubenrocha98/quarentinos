package org.academiadecodigo.apiores.quarentinos.persistence.dao;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {

    public ClientDaoImpl(){
        super(Client.class);
    }
}
