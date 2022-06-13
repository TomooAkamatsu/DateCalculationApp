package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/date-calculation")
@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "login";

    }

    @GetMapping("/logout")
    public String logoutForm() {
        return "logout";

    }
}
