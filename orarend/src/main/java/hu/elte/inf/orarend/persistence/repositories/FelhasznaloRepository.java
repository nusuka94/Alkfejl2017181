package hu.elte.inf.orarend.persistence.repositories;

import hu.elte.inf.orarend.persistence.models.Felhasznalo;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FelhasznaloRepository extends CrudRepository<Felhasznalo, Long>{
    Optional<Felhasznalo> findByFelhasznalonev(String felhasznalonev);
    
    Optional<Felhasznalo> findByFelhasznalonevAndJelszo(String felhasznalonev, String jelszo);
}
