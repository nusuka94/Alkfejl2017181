package hu.elte.inf.orarend.web.services;

import hu.elte.inf.orarend.persistence.models.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import hu.elte.inf.orarend.persistence.repositories.UserRepository;
import lombok.Data;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope //egy HTTP session során csak egy ilyen osztályt kell példányosítani, és ezt kell mindenhol használnia
@Data
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private User user;

    public User login(User user) {
        if(isValid(user)) {
            return this.user = userRepository.findByUsername(user.getUsername()).get();
        }
        return null;
    }

    public void logout() {
        this.user = null;
    }

    public User register(User user) {
        user.setRole(User.Role.USER);
        this.user = userRepository.save(user);
        return user;
    }

    public boolean isValid(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isPresent();
    }

    public boolean isLoggedIn() {
        return user != null;
    }
}
