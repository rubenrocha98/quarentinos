package org.academiadecodigo.apiores.quarentinos.controllers;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;
import org.academiadecodigo.apiores.quarentinos.persistence.model.Login;
import org.academiadecodigo.apiores.quarentinos.services.AuthService;
import org.academiadecodigo.apiores.quarentinos.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LogInController {

    private ClientService clientService;
    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginPage(Model model){
        model.addAttribute("login", new Login());
        return "login";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@ModelAttribute Login login, HttpSession session){

        if(!authService.checkLogin(login)){
            return "redirect:/login";
        }

        Client client = authService.get(login.getUsername()).getClient();

            session.setAttribute("client",client);

        return "redirect: profile/"+client.getId();
    }

    @RequestMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("register", new Client());
        model.addAttribute("login", new Login());

        return "register";
    }
}
