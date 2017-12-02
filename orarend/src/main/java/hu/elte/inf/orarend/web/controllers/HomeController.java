package hu.elte.inf.orarend.web.controllers;
import hu.elte.inf.orarend.web.services.UserService;
import hu.elte.inf.orarend.web.services.annotations.Authorized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Authorized
public class HomeController{

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public Object index(Model model) {
        model.addAttribute("title", "Órarend tervező");
        model.addAttribute("welcome", "Üdvözöllek az oldalon!");

        return "index";
    }
}
