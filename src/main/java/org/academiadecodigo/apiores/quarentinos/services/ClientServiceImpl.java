package org.academiadecodigo.apiores.quarentinos.services;

import org.academiadecodigo.apiores.quarentinos.persistence.dao.ClientDao;
import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements  ClientService {

    private ClientDao clientDao;


    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }


    @Override
    public Client get(Integer id) {
        return clientDao.find(id);
    }

    @Transactional
    @Override
    public List<Client> getAll() {
        return clientDao.findAll();
    }

    @Transactional
    @Override
    public Client save(Client client) {
        return clientDao.saveOrUpdate(client);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws Exception {

        Client client = clientDao.find(id);

        if(client == null){
            throw new Exception();
        }

        clientDao.delete(id);

    }
}
