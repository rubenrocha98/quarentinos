package org.academiadecodigo.apiores.quarentinos.controllers;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;
import org.academiadecodigo.apiores.quarentinos.persistence.model.Login;
import org.academiadecodigo.apiores.quarentinos.services.AuthService;
import org.academiadecodigo.apiores.quarentinos.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
        System.out.println(client);

        return "redirect:/profile";
    }

    @RequestMapping("/register")
    public String registerPage(Model model){
        Client client = new Client();
        client.setLogin(new Login());
        model.addAttribute("register", client);


        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String register (@Valid @ModelAttribute Client client, BindingResult bindingResult, HttpSession session, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("register",client);
            return "register";
        }

        Client clientSaved = clientService.save(client);
        if(clientSaved == null){
            return "redirect:/register";
        }


        session.setAttribute("client", clientSaved);
        session.setMaxInactiveInterval(600);
        return "redirect:/profile";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
