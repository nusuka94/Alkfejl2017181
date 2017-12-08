package hu.elte.inf.orarend.web.services;

import hu.elte.inf.orarend.persistence.models.Courses;
import hu.elte.inf.orarend.persistence.models.Subjects;
import hu.elte.inf.orarend.persistence.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    public Courses findByInstructor(String instructor) {
        return coursesRepository.findByInstructor(instructor);
    }

    public Iterable<Courses> findAll() {
        return coursesRepository.findAll();
    }

    public Iterable<Courses> findAllBySubject(Subjects subject) { return coursesRepository.findAllBySubject(subject); }
}
