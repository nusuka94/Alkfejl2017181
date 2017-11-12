package hu.elte.inf.orarend.web.services;

import hu.elte.inf.orarend.persistence.models.Felhasznalo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import hu.elte.inf.orarend.persistence.repositories.FelhasznaloRepository;
import lombok.Data;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope //egy HTTP session során csak egy ilyen osztályt kell példányosítani, és ezt kell mindenhol használnia
@Data
public class FelhasznaloService {
    
    @Autowired
    private FelhasznaloRepository felhasznaloRepository;
    
    private Felhasznalo felhasznalo;
    
    public Felhasznalo login(Felhasznalo felhasznalo) {
        if(isValid(felhasznalo)) {
            return this.felhasznalo = felhasznaloRepository.findByFelhasznalonev(felhasznalo.getFelhasznalonev()).get();
        }
        return null;
    }
    
    public Felhasznalo register(Felhasznalo felhasznalo) {
        felhasznalo.setRole(Felhasznalo.Role.USER);
        this.felhasznalo = felhasznaloRepository.save(felhasznalo);
        return felhasznalo;
    }
    
    /*public Felhasznalo findByFelhasznalonev(String felhasznalonev) {
        return hallgatoRepository.findByFelhasznalonev(felhasznalonev);
    }*/
    
    public boolean isValid(Felhasznalo felhasznalo) {
        return felhasznaloRepository.findByFelhasznalonevAndJelszo(felhasznalo.getFelhasznalonev(), felhasznalo.getJelszo()).isPresent();
    }
    
    public boolean isLoggedIn() {
        return felhasznalo != null;
    }
}
