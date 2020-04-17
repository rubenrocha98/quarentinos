package org.academiadecodigo.apiores.quarentinos.controllers;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Provider;
import org.academiadecodigo.apiores.quarentinos.persistence.model.RoleType;
import org.academiadecodigo.apiores.quarentinos.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;

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
        model.addAttribute("providers",new LinkedList<>());
        return "userPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hitmans")
    public String showHitmans(Model model, HttpSession session){

        if(session.getAttribute("client")==null){
            return "redirect:/";
        }

        model.addAttribute("client",session.getAttribute("client"));
        model.addAttribute("providers", providerService.getByRole(RoleType.HITMAN));

        return "userPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/framer")
    public String showCops(Model model, HttpSession session){

        if(session.getAttribute("client")==null){
            return "redirect:/";
        }

        model.addAttribute("client",session.getAttribute("client"));
        model.addAttribute("providers", providerService.getByRole(RoleType.FRAMER));

        return "userPage";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/detectives")
    public String showDetectives(Model model, HttpSession session){

        if(session.getAttribute("client")==null){
            return "redirect:/";
        }

        model.addAttribute("client",session.getAttribute("client"));
        model.addAttribute("providers", providerService.getByRole(RoleType.DETECTIVE));

        return "userPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/insurance")
    public String showInsurance(Model model, HttpSession session){

        if(session.getAttribute("client")==null){
            return "redirect:/";
        }

        model.addAttribute("client",session.getAttribute("client"));
        model.addAttribute("providers", providerService.getByRole(RoleType.INSURANCE_AGENT));

        return "userPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/escorts")
    public String showEscorts(Model model, HttpSession session){

        if(session.getAttribute("client")==null){
            return "redirect:/";
        }

        model.addAttribute("client",session.getAttribute("client"));
        model.addAttribute("providers", providerService.getByRole(RoleType.PROSTITUTION));

        return "userPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/buy")
    public String askForCreditCardInfo(){

        return "creditCard";
    }



}
