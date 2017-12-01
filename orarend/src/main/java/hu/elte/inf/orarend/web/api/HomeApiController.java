package hu.elte.inf.orarend.web.api;

import hu.elte.inf.orarend.web.services.FelhasznaloService;
import hu.elte.inf.orarend.web.services.TermekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@SessionScope
@RequestMapping("/api/home")
public class HomeApiController {

    @Autowired
    private TermekService termekService;

    @Autowired
    private FelhasznaloService userService;

    @RequestMapping(value = "/termek", method = RequestMethod.POST)
    public Object termek() {
        if(!userService.isLoggedIn()) {
            return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        return termekService.findAll();
    }
}
