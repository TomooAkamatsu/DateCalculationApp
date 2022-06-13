package com.example.demo.controller;

import com.example.demo.domain.UserForm;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/date-calculation/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String showUserList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "userList";
    }

    @GetMapping("/creation-form")
    public String showCreationForm(@ModelAttribute UserForm userForm) {
        return "creationForm";
    }

    @PostMapping
    public String createUser(@Validated UserForm userForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) return showCreationForm(userForm);

        userService.create(userForm.getUsername(), userForm.getPassword(), userForm.getAuthority());
        return "redirect:/date-calculation/users";
    }
}
