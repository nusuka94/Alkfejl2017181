package hu.elte.inf.orarend.web.api;

import hu.elte.inf.orarend.web.services.CoursesService;
import hu.elte.inf.orarend.web.services.UserService;
import hu.elte.inf.orarend.web.services.RoomsService;
import hu.elte.inf.orarend.web.services.annotations.Authorized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@SessionScope
@RequestMapping("/api/home")
@Authorized
public class HomeApiController {

    @Autowired
    private RoomsService roomsService;

    @Autowired
    private UserService userService;

    @Autowired
    private CoursesService coursesService;

    @RequestMapping(value = "/termek", method = RequestMethod.POST)
    public Object termek() {
        return roomsService.findAll();
    }

    @RequestMapping(value = "/kurzusok", method = RequestMethod.POST)
    public Object kurzusok() {
        return coursesService.findAll();
    }
}
