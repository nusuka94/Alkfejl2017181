package hu.elte.inf.orarend.web.controllers;
import hu.elte.inf.orarend.persistence.models.Felhasznalo;
import hu.elte.inf.orarend.persistence.models.Termek;
import hu.elte.inf.orarend.web.services.FelhasznaloService;
import hu.elte.inf.orarend.web.services.annotations.Authorized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Authorized
public class HomeController{

    @Autowired
    private FelhasznaloService userService;

    @GetMapping("/index")
    public Object index(Model model) {
        model.addAttribute("title", "Órarend tervező");
        model.addAttribute("welcome", "Üdvözöllek az oldalon!");

        return "index";
    }
}
