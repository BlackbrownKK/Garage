package com.example.garage.controller;

import com.example.garage.model.Car;
import com.example.garage.model.Client;
import com.example.garage.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    private final ClientService clientServise;


    public LoginController (ClientService clientServise) {
        this.clientServise = clientServise;
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/registeretion")
    public String registeretioNewClient(Model model) {
        model.addAttribute("user", Client.builder()
                .build());
        return "registeretion";
    }

    // https://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html

//    @PostMapping("/login")
//    public String autorisation(@ModelAttribute("client") @RequestBody Client client, Model model) {
//        System.out.println(client.getClientEmail());
//        System.out.println(client.getClientPassword());
//
//        System.out.println(clientServise.findByEmail(client.getClientEmail()).getClientFirstName());
//        return "localhost:8080/garage";
//    }

    @PostMapping("/registeretion/save")
    public String saveNewClient(@ModelAttribute("user") Client client, BindingResult result, Model model) {

        Client presentClient = clientServise.findByEmail(client.getClientEmail());
        if (presentClient != null
                && presentClient.getClientEmail() != null
                && !presentClient.getClientEmail().isEmpty()) {
            result.rejectValue("clientEmail", "IsExist", "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", client);
            return "/registeretion";
        }

        clientServise.saveUser(client);
        return "redirect:/login";
    }
}