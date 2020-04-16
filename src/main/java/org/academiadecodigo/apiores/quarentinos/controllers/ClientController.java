package org.academiadecodigo.apiores.quarentinos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ClientController {

    @RequestMapping(method = RequestMethod.GET, value = "/profile/{id}")
    public String showProfile(Model model, HttpSession session, @PathVariable Integer id){

        if(session.getAttribute("client")==null){
            return "redirect:/";
        }

        model.addAttribute("client",session.getAttribute("client"));

        return "shit";
    }


}
