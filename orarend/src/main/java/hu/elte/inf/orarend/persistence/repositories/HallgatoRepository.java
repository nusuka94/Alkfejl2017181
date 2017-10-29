package hu.elte.inf.orarend.persistence.repositories;

import hu.elte.inf.orarend.persistence.models.Hallgato;
import org.springframework.data.repository.CrudRepository;

public interface HallgatoRepository extends CrudRepository<Hallgato, Long>{
    Hallgato findByFelhasznalonev(String felhasznalonev);
}
