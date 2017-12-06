package hu.elte.inf.orarend.persistence.repositories;
import hu.elte.inf.orarend.persistence.models.Courses;
import hu.elte.inf.orarend.persistence.models.Subjects;
import org.springframework.data.repository.CrudRepository;

public interface CoursesRepository extends CrudRepository<Courses, Long>{

    Courses findByInstructor(String instructor);
    Courses findByDay(String day);
    Courses findByStartTime(String startTime);
    Iterable<Courses> findAllBySubject(Subjects subject);

//    @Query("select s.firstname from Student s where s.firstname like ?1%")
//    List<Subjects> findByFirstNameSegment(String firstName);
}
