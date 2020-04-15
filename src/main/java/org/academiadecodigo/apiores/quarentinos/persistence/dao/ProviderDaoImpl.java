package org.academiadecodigo.apiores.quarentinos.persistence.dao;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Provider;
import org.springframework.stereotype.Repository;

@Repository
public class ProviderDaoImpl extends AbstractDao<Provider> implements ProviderDao {

    public ProviderDaoImpl(){
        super(Provider.class);
    }

}
