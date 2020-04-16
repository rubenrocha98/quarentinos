package org.academiadecodigo.apiores.quarentinos.services;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Login;

import java.util.Set;

public interface AuthService {

    Login addLogin(Login login);

    boolean checkLogin(Login login);

    Login get(String username);

    Set<Login> getLogins();
}
