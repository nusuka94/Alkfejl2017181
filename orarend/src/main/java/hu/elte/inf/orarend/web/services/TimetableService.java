/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.inf.orarend.web.services;

import hu.elte.inf.orarend.persistence.models.Courses;
import hu.elte.inf.orarend.persistence.models.Timetable;
import hu.elte.inf.orarend.persistence.models.User;
import hu.elte.inf.orarend.persistence.repositories.CoursesRepository;
import hu.elte.inf.orarend.persistence.repositories.TimetableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nusi-PC
 */
@Service
public class TimetableService {
    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    private CoursesService coursesService;
    
    public Iterable<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    private Timetable timetable;

    public Timetable findById(long id) { return timetableRepository.findById(id); }

//    public Iterable<Timetable> listByUser(User user) {
//        if(user == null) {
//            return timetableRepository.findAll();
//        }
//        //String username = user.getUsername();
//        long userId = user.getId();
//        return timetableRepository.findByUser(userId);
//    }
    
    public Timetable create(Timetable timetable) {
        this.timetable = timetableRepository.save(timetable);
        return timetable;
    }

    public Iterable<Timetable> findByUserId(long id) {
        return timetableRepository.findByUserId(id);
    }
    
    public void delete(long id) {
        timetableRepository.delete(id);
    }

    public Timetable read(long id) {
        return timetableRepository.findOne(id);
    }

//    public void addCourseToTimetable(long tid, long cid) {
//        timetableRepository.addCourseToTimetable(tid,cid);
//        System.out.println(tid + " " + cid);
//    }

    public void addCourseToTimetable(long tid, long cid) {
        read(tid).courses.add(coursesRepository.findById(cid));
    }
}
