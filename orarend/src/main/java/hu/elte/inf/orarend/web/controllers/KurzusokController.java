package hu.elte.inf.orarend.web.controllers;
import hu.elte.inf.orarend.web.services.KurzusokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KurzusokController {

    /*@Autowired
    private KurzusokService kurzusokService;

    @RequestMapping("/hello")
    public String hello(Model model) {
        System.out.print(kurzusokService.findAll());
        model.addAttribute("list", kurzusokService.findAll());
        model.addAttribute("title", "CICIK ( . Y . )");
        return "hello";
    }*/
}
