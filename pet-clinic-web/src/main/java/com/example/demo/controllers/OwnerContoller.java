package com.example.demo.controllers;

import com.example.demo.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerContoller {

    private final OwnerService ownerService;

    public OwnerContoller(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners"})
    public String getOwners(Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping({"/owners/find", "/oups"})
    public String findOwners() {
        return "notImplemented";
    }

}
