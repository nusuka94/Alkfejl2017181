package hu.elte.inf.orarend.web.api;

import hu.elte.inf.orarend.persistence.models.Courses;
import hu.elte.inf.orarend.persistence.models.Subjects;
import hu.elte.inf.orarend.persistence.models.Timetable;
import hu.elte.inf.orarend.persistence.models.User;
import hu.elte.inf.orarend.persistence.repositories.TimetableRepository;
import hu.elte.inf.orarend.web.services.CoursesService;
import hu.elte.inf.orarend.web.services.TimetableService;
import hu.elte.inf.orarend.web.services.UserService;
import hu.elte.inf.orarend.web.services.RoomsService;
import hu.elte.inf.orarend.web.services.annotations.Authorized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Autowired
    private TimetableRepository timetableRepository;

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
    public ResponseEntity<Iterable<Timetable>> userTimetables(@RequestParam long id) {
        return ResponseEntity.ok(timetableService.findByUserId(id));
    }

    @GetMapping("/coursebyid")
    public ResponseEntity<Courses> getById(@RequestParam long id) {
        return ResponseEntity.ok(coursesService.findById(id));
    }

    @DeleteMapping("/timetables/{id}")
    public ResponseEntity deleteTimetable(@PathVariable long id) {
        timetableService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/timetables/{id}")
    public ResponseEntity<Timetable> read(@PathVariable String id) {
        Timetable read = timetableService.read(Integer.parseInt(id));
        return ResponseEntity.ok(read);
    }

    @PostMapping("/timetables/{id}")
    public ResponseEntity addCourseToTimetable(@PathVariable String id, @RequestParam String cid) {
        timetableService.addCourseToTimetable(Long.parseLong(id),Long.parseLong(cid));
        return ResponseEntity.ok().build();
    }
}
