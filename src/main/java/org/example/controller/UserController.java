package org.example.controller;

import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/mvc/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }
    @GetMapping("/mvc/users/{id}")
    public String getAllUsers(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id).orElse(null));
        return "user";
    }
}