package hu.elte.inf.orarend.web.services;

import hu.elte.inf.orarend.persistence.models.Kurzusok;
import hu.elte.inf.orarend.persistence.repositories.KurzusokRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KurzusokService {

    @Autowired
    private KurzusokRepository kurzusokRepository;

    public Kurzusok findByOktato(String oktato) {
        return kurzusokRepository.findByOktato(oktato);
    }

    public Iterable<Kurzusok> findAll() {
        return kurzusokRepository.findAll();
    }
}
