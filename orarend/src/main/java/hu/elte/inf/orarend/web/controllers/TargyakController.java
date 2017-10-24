package hu.elte.inf.orarend.web.controllers;

import hu.elte.inf.orarend.persistence.repositories.TargyakRepository;
import hu.elte.inf.orarend.web.services.TargyakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TargyakController{

    @Autowired
    private TargyakService targyakService;

    @RequestMapping("/hello")
    public String hello(Model model) {
        System.out.print(targyakService.findAll());
        model.addAttribute("list", targyakService.findAll());
        model.addAttribute("title", "CICIK ( . Y . )");
        return "hello";
    }
}
