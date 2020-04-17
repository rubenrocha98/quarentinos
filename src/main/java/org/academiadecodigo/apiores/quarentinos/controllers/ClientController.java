package org.academiadecodigo.apiores.quarentinos.controllers;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Provider;
import org.academiadecodigo.apiores.quarentinos.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ClientController {
    private ProviderService providerService;

    @Autowired
    public void setProviderService(ProviderService providerService) {
        this.providerService = providerService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    public String showProfile(Model model, HttpSession session){

        if(session.getAttribute("client")==null){
            return "redirect:/";
        }

        model.addAttribute("client",session.getAttribute("client"));
        model.addAttribute("providers", providerService.getAll());

        return "userPage";
    }

}
