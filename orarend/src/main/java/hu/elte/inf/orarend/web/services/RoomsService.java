package hu.elte.inf.orarend.web.services;
import hu.elte.inf.orarend.persistence.models.Rooms;
import hu.elte.inf.orarend.persistence.repositories.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsService {

    @Autowired
    private RoomsRepository roomsRepository;

    public Rooms findByRoom(String room) {
        return roomsRepository.findByRoom(room);
    }

    public Iterable<Rooms> findAll() {
        return roomsRepository.findAll();
    }
}
