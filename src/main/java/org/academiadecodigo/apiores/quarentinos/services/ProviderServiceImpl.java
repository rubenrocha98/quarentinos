package org.academiadecodigo.apiores.quarentinos.services;
import org.academiadecodigo.apiores.quarentinos.persistence.model.Provider;

import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProviderServiceImpl implements ProviderService {


    private Integer id;
    private Map<Integer, Provider> providerMap;

    public ProviderServiceImpl() {
        id = 0;
        this.providerMap = new HashMap<>();
    }

    @Override
    public Provider get(Integer id) {
        return providerMap.get(id);
    }



    @Override
    public List<Provider> getAll() {
        return providerMap.values().stream()
                .collect(Collectors.toList());
    }



    @Override
    public Provider save(Provider provider) {
        id++;
        provider.setId(id);
        providerMap.put(id, provider);
        return provider;
    }



    @Override
    public void delete(Integer id) throws Exception {
        providerMap.remove(id);
    }
}
