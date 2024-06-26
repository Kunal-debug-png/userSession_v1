package com.example.user.controller;

import com.example.user.model.UserDtls;
import com.example.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/signin")
    public String login(){

        return "login";
    }
    @GetMapping("/register")
    public String register(){

        return "register";
    }
    @PostMapping("/createUser")
    public String createUser(@ModelAttribute UserDtls user, HttpSession session) {
        boolean emailExists = userService.checkEmail(user.getEmail());
        if (emailExists) {
            session.setAttribute("msg", "Email already exists. Please try with a different email.");
        } else {
            UserDtls userDtls = userService.createUser(user);
            if (userDtls != null) {
                session.setAttribute("msg", "Registration successful!");
            } else {
                session.setAttribute("msg", "Registration failed. Please try again.");
            }
        }
        return "redirect:/register";
    }

}
