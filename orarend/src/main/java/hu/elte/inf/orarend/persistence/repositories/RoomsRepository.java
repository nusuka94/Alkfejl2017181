package hu.elte.inf.orarend.persistence.repositories;
import hu.elte.inf.orarend.persistence.models.Rooms;
import org.springframework.data.repository.CrudRepository;

public interface RoomsRepository extends CrudRepository<Rooms, Long>{

    Rooms findByRoom(String room);

//    @Query("select s.firstname from Student s where s.firstname like ?1%")
//    List<Subjects> findByFirstNameSegment(String firstName);
}
