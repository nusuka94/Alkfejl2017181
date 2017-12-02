package hu.elte.inf.orarend.persistence.repositories;

import hu.elte.inf.orarend.persistence.models.User;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FelhasznaloRepository extends CrudRepository<User, Long>{
    Optional<User> findByFelhasznalonev(String felhasznalonev);
    
    Optional<User> findByFelhasznalonevAndJelszo(String felhasznalonev, String jelszo);
}
