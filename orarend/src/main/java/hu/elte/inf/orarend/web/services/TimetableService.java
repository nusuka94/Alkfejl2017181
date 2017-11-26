/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.inf.orarend.web.services;

import hu.elte.inf.orarend.persistence.models.Timetable;
import hu.elte.inf.orarend.persistence.repositories.TimetableRepository;
import hu.elte.inf.orarend.persistence.models.Felhasznalo;

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
    
    public Iterable<Timetable> timetables() {
        return timetableRepository.findAll();
    }
    
    public Iterable<Timetable> listByUser(Felhasznalo user) {
        if(user == null) {
            return timetableRepository.findAll();
        }
        String username = user.getFelhasznalonev();
        return timetableRepository.findByOwner(username);
    }
    
    public Timetable create(Timetable timetable) {
        return timetableRepository.save(timetable);
    }
    
    public void delete(int id) {
        timetableRepository.delete(id);
    }
    
    public Timetable read(String name) {
        return timetableRepository.findByName(name);
    }
}
