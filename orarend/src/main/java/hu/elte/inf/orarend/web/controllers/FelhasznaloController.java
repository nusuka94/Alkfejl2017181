package hu.elte.inf.orarend.web.controllers;

import hu.elte.inf.orarend.persistence.models.Felhasznalo;
import hu.elte.inf.orarend.web.services.FelhasznaloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FelhasznaloController {
    
    @Autowired
    private FelhasznaloService felhasznaloService;
    
    @GetMapping("/greet")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        return "greeting";
    }

    /*@GetMapping("/index")
    public String index(String name, Model model) {
        model.addAttribute("name",name);
        return "index";
    }*/
    
    //@GetMapping("/login")
    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute(new Felhasznalo());
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute Felhasznalo felhasznalo, Model model) {
        if(felhasznaloService.isValid(felhasznalo)) {
            return redirectToGreeting(felhasznalo);
        }
        model.addAttribute("loginFailed",true);
        return "login";
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("felhasznalo",new Felhasznalo());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(@RequestBody Felhasznalo felhasznalo) {
        felhasznaloService.register(felhasznalo);
        //return felhasznalo;
        return redirectToGreeting(felhasznalo);
    }
    
    private String redirectToGreeting(@RequestBody Felhasznalo felhasznalo) {
        //return "redirect:/greet?name=" + felhasznalo.getFelhasznalonev();
        return "redirect:/api/felhasznalo";
    }
}
