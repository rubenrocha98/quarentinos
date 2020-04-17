package org.academiadecodigo.apiores.quarentinos.services;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;
import org.academiadecodigo.apiores.quarentinos.persistence.model.Provider;
import org.academiadecodigo.apiores.quarentinos.persistence.model.RoleType;

import java.util.List;

public interface ProviderService {

    Provider get(Integer id);

    List<Provider> getAll();

    Provider save(Provider provider);

    void delete(Integer id) throws Exception;

    List<Provider> getByRole(RoleType roleType);
}
