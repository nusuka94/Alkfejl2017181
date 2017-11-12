package hu.elte.inf.orarend.web.services;

import hu.elte.inf.orarend.persistence.models.Hallgato;
import hu.elte.inf.orarend.persistence.repositories.HallgatoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class HallgatoService {
    
    @Autowired
    private HallgatoRepository hallgatoRepository;
    
    public Hallgato findByFelhasznalonev(String felhasznalonev) {
        return hallgatoRepository.findByFelhasznalonev(felhasznalonev);
    }
    
    
}
