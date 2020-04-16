package org.academiadecodigo.apiores.quarentinos.controllers;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;
import org.academiadecodigo.apiores.quarentinos.persistence.model.Login;
import org.academiadecodigo.apiores.quarentinos.services.AuthService;
import org.academiadecodigo.apiores.quarentinos.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private AuthService authService;
    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("login",new Login());

        return "login";
    }

    @RequestMapping("/test")
    public String populate(Model model){
        /*Client client = new Client();
        Login login = new Login();
        login.setUsername("Ruben");
        login.setPassword("fonas");
        client.setLogin(login);
        client.setFirstName("Ruben");
        login.setClient(client);
        clientService.save(client);

        System.out.println(client.getLogin().getUsername());

        System.out.println(authService);
        System.out.println(authService.getLogins());*/

        model.addAttribute("logins",authService.getLogins());

        return "index";
    }


}
