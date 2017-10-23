package hu.elte.inf.orarend.persistence.repositories;
import java.util.List;
import hu.elte.inf.orarend.persistence.models.Kurzusok;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface KurzusokRepository extends CrudRepository<Kurzusok, Long>{

    Kurzusok findByOktato(String oktato);

//    @Query("select s.firstname from Student s where s.firstname like ?1%")
//    List<Targyak> findByFirstNameSegment(String firstName);
}
