package org.academiadecodigo.apiores.quarentinos.services;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;
import org.academiadecodigo.apiores.quarentinos.persistence.model.Login;
import org.academiadecodigo.apiores.quarentinos.persistence.model.Provider;
import org.academiadecodigo.apiores.quarentinos.persistence.model.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl implements  ClientService {

    private Integer id;
    private Map<Integer, Client> clients;
    private AuthService authService;
    private ProviderService providerService;


    public ClientServiceImpl(){
        clients = new HashMap<>();
        id = 0;

    }

    @Autowired
    public void setProviderService(ProviderService providerService) {
        this.providerService = providerService;
        populateProvider();
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

    private void populateProvider(){

        Provider providerHitman = new Provider();
        providerHitman.setPriceMax(200000);
        providerHitman.setPriceMin(15000);
        providerHitman.setRoleType(RoleType.HITMAN);
        providerHitman.setFirstName("Ruben");
        providerHitman.setLastName("Rocha");
        providerHitman.setPhone("963616102");
        providerHitman.setEmail("rubenrocha@gmail.com");
        providerHitman.setGender("Reptilian");

        Provider hooker = new Provider();
        hooker.setPriceMax(1000);
        hooker.setPriceMin(200);
        hooker.setRoleType(RoleType.PROSTITUTION);
        hooker.setFirstName("Andreya");
        hooker.setLastName("Brancqa");
        hooker.setPhone("965049918");
        hooker.setEmail("branquinha@gmail.com");
        hooker.setGender("Shemale");

        Provider hooker2 = new Provider();
        hooker2.setPriceMax(1000);
        hooker2.setPriceMin(200);
        hooker2.setRoleType(RoleType.PROSTITUTION);
        hooker2.setFirstName("Kobe");
        hooker2.setLastName("Bryant");
        hooker2.setPhone("295029789");
        hooker2.setEmail("negao@gmail.com");
        hooker2.setGender("Male");

        Provider badCop = new Provider();
        badCop.setPriceMax(5000);
        badCop.setPriceMin(2000);
        badCop.setRoleType(RoleType.FRAMER);
        badCop.setFirstName("Mauricio");
        badCop.setLastName("Jeremias");
        badCop.setPhone("934582981");
        badCop.setEmail("conspiration_master@gmail.com");
        badCop.setGender("Male");

        Provider insuranceAgent = new Provider();
        insuranceAgent.setPriceMax(4000);
        insuranceAgent.setPriceMin(1500);
        insuranceAgent.setRoleType(RoleType.FRAMER);
        insuranceAgent.setFirstName("Evandro");
        insuranceAgent.setLastName("Mendes");
        insuranceAgent.setPhone("934582981");
        insuranceAgent.setEmail("evandro_mendes_zurich@gmail.com");
        insuranceAgent.setGender("Male");

        Provider detective = new Provider();
        detective.setPriceMax(5000);
        detective.setPriceMin(1500);
        detective.setRoleType(RoleType.DETECTIVE);
        detective.setFirstName("Chico");
        detective.setLastName("Carreiro");
        detective.setPhone("924129477");
        detective.setEmail("psycho_detetive@gmail.com");
        detective.setGender("Reptilian");

        providerService.save(providerHitman);
        providerService.save(hooker);
        providerService.save(hooker2);
        providerService.save(detective);
        providerService.save(insuranceAgent);
        providerService.save(badCop);
    }

}
