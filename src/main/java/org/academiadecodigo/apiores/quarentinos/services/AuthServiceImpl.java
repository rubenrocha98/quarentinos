package org.academiadecodigo.apiores.quarentinos.services;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Login;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthServiceImpl implements AuthService{

    private List<Login> logins;

    public AuthServiceImpl() {
        logins = new ArrayList<>();
    }

    public Login addLogin(Login login){
        if(!loginAvailable(login)){
            return null;
        }
        logins.add(login);
        return login;
    }

    @Override
    public boolean checkLogin(Login login) {
        for (Login log : logins) {
            if(log.getPassword().equals(login.getPassword()) && log.getUsername().equals(login.getUsername())){
                return true;
            }
        }
        return false;

    }

    private boolean loginAvailable(Login login){
        for (Login log : logins) {
            if(log.getUsername().equals(login.getUsername())){
                return false;
            }
        }
        return true;
    }

    @Override
    public Login get(String username) {
        for (Login login : logins) {
            if(login.getUsername().equals(username)){
                return login;
            }
        }
        return null;
    }

    @Override
    public List<Login> getLogins() {
        return logins;
    }
}
