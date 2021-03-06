package org.academiadecodigo.apiores.quarentinos.controllers;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;
import org.academiadecodigo.apiores.quarentinos.persistence.model.Login;
import org.academiadecodigo.apiores.quarentinos.services.AuthService;
import org.academiadecodigo.apiores.quarentinos.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String index(HttpServletRequest httpRequest, Model model, HttpSession session){
        Client client = (Client) session.getAttribute("client");
        if(client!=null){
            return "redirect:/profile";
        }
        model.addAttribute("url",httpRequest.getRequestURL());
        model.addAttribute("signUpUrl", httpRequest.getRequestURL());
        return "index";
    }

    @RequestMapping("/test")
    public String populate(Model model){

        model.addAttribute("logins",authService.getLogins());

        return "index";
    }


}
