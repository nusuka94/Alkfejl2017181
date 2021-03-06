package hu.elte.inf.orarend.persistence.repositories;

import hu.elte.inf.orarend.persistence.models.Subjects;
import org.springframework.data.repository.CrudRepository;

public interface SubjectsRepository extends CrudRepository<Subjects, Long> {

    Subjects findByCode(String code);

//    @Query("select s.firstname from Student s where s.firstname like ?1%")
//    List<Subjects> findByFirstNameSegment(String firstName);
}
