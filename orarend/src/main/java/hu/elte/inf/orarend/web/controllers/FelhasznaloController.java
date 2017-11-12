package hu.elte.inf.orarend.web.controllers;

import hu.elte.inf.orarend.web.services.HallgatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HallgatoController {
    
    @Autowired
    private HallgatoService hallgatoService;
    
    @RequestMapping("/hallgatok")
    public String hallgatok(Model model) {
        System.out.print("Hallgatók");
        
        return "hallgatok";
    }
}
