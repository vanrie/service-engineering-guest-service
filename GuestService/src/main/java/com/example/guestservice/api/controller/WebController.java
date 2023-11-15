package com.example.guestservice.api.controller;

import com.example.guestservice.api.db.QueryRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

public class WebController {

    // Placeholder for customerDAO (you should replace this with your actual DAO)
    private final QueryRepository data;

    // Constructor to inject CustomerDAO (dependency injection)
    public WebController(QueryRepository data) {
        this.data = data;
    }

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
        model.addAttribute("customers", data.getAllUsers());
        model.addAttribute("username", principal.getName());
        return "customers";
    }
}
