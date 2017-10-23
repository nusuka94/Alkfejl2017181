package hu.elte.inf.orarend.web.controllers;
import hu.elte.inf.orarend.web.services.TermekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TermekController {

    @Autowired
    private TermekService termekService;

    @RequestMapping("/termek")
    public String termek(Model model) {
        System.out.print(termekService.findAll());
        model.addAttribute("list", termekService.findAll());
        model.addAttribute("title", "Termek");
        return "termek";
    }
}
