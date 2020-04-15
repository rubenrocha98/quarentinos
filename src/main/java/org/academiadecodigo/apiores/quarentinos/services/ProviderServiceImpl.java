package org.academiadecodigo.apiores.quarentinos.services;

import org.academiadecodigo.apiores.quarentinos.persistence.dao.ProviderDao;
import org.academiadecodigo.apiores.quarentinos.persistence.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {


    private ProviderDao providerDao;

    @Autowired
    public void setProviderDao(ProviderDao providerDao) {
        this.providerDao = providerDao;
    }

    
    @Transactional
    @Override
    public Provider get(Integer id) {
        return providerDao.find(id);
    }


    @Transactional
    @Override
    public List<Provider> getAll() {
        return providerDao.findAll();
    }


    @Transactional
    @Override
    public Provider save(Provider provider) {
        return providerDao.saveOrUpdate(provider);
    }


    @Transactional
    @Override
    public void delete(Integer id) throws Exception {

        Provider provider = providerDao.find(id);

        if(provider == null){
            throw new Exception();
        }

        providerDao.delete(id);
    }
}
