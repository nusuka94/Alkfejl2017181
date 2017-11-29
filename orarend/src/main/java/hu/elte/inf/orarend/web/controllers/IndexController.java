package hu.elte.inf.orarend.web.controllers;
import hu.elte.inf.orarend.persistence.models.Felhasznalo;
import hu.elte.inf.orarend.persistence.models.Termek;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController{

//    @RequestMapping("/index")
//    public void index(Model model) {
//        model.addAttribute("title", "Órarend tervező");
//        model.addAttribute("welcome", "Üdvözöllek az oldalon!");
//    }

    /*@RequestMapping(value = "/api/index/szar", method = RequestMethod.POST)
    public Object szar(@RequestBody Felhasznalo param) {
        //kiszámoljuk a 42. fibonnaci számot
        //... valami kód
        Termek terem = new Termek();
        terem.setId(666);
        terem.setNev("szar");

        return terem;
    }*/

}
