package hu.elte.inf.orarend.web.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController{

    @RequestMapping("/index")
    public void index(Model model) {
        model.addAttribute("title", "Órarend tervező");
        model.addAttribute("welcome", "Üdvözöllek az oldalon!");
    }
}
