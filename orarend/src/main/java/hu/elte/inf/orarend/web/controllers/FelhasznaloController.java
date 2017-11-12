package hu.elte.inf.orarend.web.controllers;

import hu.elte.inf.orarend.persistence.models.Felhasznalo;
import hu.elte.inf.orarend.web.services.FelhasznaloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/felhasznalo")
public class FelhasznaloController {
    
    @Autowired
    private FelhasznaloService felhasznaloService;
    
    @GetMapping("/greet")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        return "greeting";
    }
    
    @GetMapping("/login")
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
    public String register(@ModelAttribute Felhasznalo felhasznalo) {
        felhasznaloService.register(felhasznalo);
        return redirectToGreeting(felhasznalo);
    }
    
    private String redirectToGreeting(@ModelAttribute Felhasznalo felhasznalo) {
        return "redirect:/felhasznalo/greet?name=" + felhasznalo.getFelhasznalonev();
    }
    
}
