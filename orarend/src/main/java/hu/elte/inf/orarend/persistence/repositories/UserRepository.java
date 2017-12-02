package hu.elte.inf.orarend.persistence.repositories;

import hu.elte.inf.orarend.persistence.models.User;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByUsername(String username);
    
    Optional<User> findByUsernameAndPassword(String username, String password);
}
