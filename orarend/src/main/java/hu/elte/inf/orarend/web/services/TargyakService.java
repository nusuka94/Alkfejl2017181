package hu.elte.inf.orarend.web.services;
import java.util.List;

import hu.elte.inf.orarend.persistence.models.Targyak;
import hu.elte.inf.orarend.persistence.repositories.TargyakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TargyakService {

    @Autowired
    private TargyakRepository targyakRepository;

    public Targyak findByKod(String kod) {
        return targyakRepository.findByKod(kod);
    }

    public Iterable<Targyak> findAll() {
        return targyakRepository.findAll();
    }
}
