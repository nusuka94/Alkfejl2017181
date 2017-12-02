package hu.elte.inf.orarend.web.controllers;

import hu.elte.inf.orarend.persistence.models.User;
import hu.elte.inf.orarend.web.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping({"/login", "/"})
    public String login(Model model) {
        model.addAttribute(new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User felhasznalo, Model model) {
        User user = userService.login(felhasznalo);
        if(user != null) {
            return "redirect:/index";
        }
        model.addAttribute("loginFailed",true);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("felhasznalo",new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        userService.register(user);
        return "redirect:/login";
    }
}
