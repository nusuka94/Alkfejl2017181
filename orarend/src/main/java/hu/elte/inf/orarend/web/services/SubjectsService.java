package hu.elte.inf.orarend.web.services;

import hu.elte.inf.orarend.persistence.models.Subjects;
import hu.elte.inf.orarend.persistence.repositories.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectsService {

    @Autowired
    private SubjectsRepository subjectsRepository;

    public Subjects findByCode(String code) {
        return subjectsRepository.findByCode(code);
    }

    public Iterable<Subjects> findAll() {
        return subjectsRepository.findAll();
    }
}
