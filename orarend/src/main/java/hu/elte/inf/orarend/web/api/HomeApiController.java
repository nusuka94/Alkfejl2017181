package hu.elte.inf.orarend.web.api;

import hu.elte.inf.orarend.persistence.models.Subjects;
import hu.elte.inf.orarend.persistence.models.Timetable;
import hu.elte.inf.orarend.persistence.models.User;
import hu.elte.inf.orarend.web.services.CoursesService;
import hu.elte.inf.orarend.web.services.TimetableService;
import hu.elte.inf.orarend.web.services.UserService;
import hu.elte.inf.orarend.web.services.RoomsService;
import hu.elte.inf.orarend.web.services.annotations.Authorized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@SessionScope
@RequestMapping("/api/home")
@Authorized
public class HomeApiController {

    @Autowired
    private CoursesService coursesService;

    @Autowired
    private TimetableService timetableService;

    @RequestMapping(value = "/courses",method = RequestMethod.GET)
    public Object courses() {
        return coursesService.findAll();
    }

    @RequestMapping(value="/timetables", method=RequestMethod.GET)
    public Object timetables() { return timetableService.findAll(); }

    //@RequestMapping(value="/newtimetable", method=RequestMethod.POST)
    @PostMapping("/newtimetable")
    public ResponseEntity<Timetable> create(@RequestBody Timetable timetable) {
        return ResponseEntity.ok(timetableService.create(timetable));
    }

    @GetMapping("/usertimetables")
    public Object userTimetables(@RequestParam User user) {
        return timetableService.getByUser(user);
    }
}
