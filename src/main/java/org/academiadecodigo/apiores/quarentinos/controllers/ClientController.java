package org.academiadecodigo.apiores.quarentinos.controllers;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Client;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

public class ClientController {

    @RequestMapping(method = RequestMethod.GET, value = "/profile/{id}")
    public String showProfile(Model model, HttpSession session){

        model.addAttribute("client",session.getAttribute("client"));

        return "shit";
    }


}
