package hu.elte.inf.orarend.web.services;
import java.util.List;
import hu.elte.inf.orarend.persistence.models.Termek;
import hu.elte.inf.orarend.persistence.repositories.TermekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermekService {

    @Autowired
    private TermekRepository termekRepository;

    public Termek findByNev(String nev) {
        return termekRepository.findByNev(nev);
    }

    public Iterable<Termek> findAll() {
        return termekRepository.findAll();
    }
}
