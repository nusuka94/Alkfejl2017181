package hu.elte.inf.orarend.persistence.repositories;
import java.util.List;
import hu.elte.inf.orarend.persistence.models.Targyak;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TargyakRepository extends CrudRepository<Targyak, Long> {

    Targyak findByKod(String kod);

//    @Query("select s.firstname from Student s where s.firstname like ?1%")
//    List<Targyak> findByFirstNameSegment(String firstName);
}