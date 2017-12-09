package hu.elte.inf.orarend.persistence.repositories;

import hu.elte.inf.orarend.persistence.models.Timetable;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends CrudRepository<Timetable,Long>{
    List<Timetable> findByUser(long userId);
}
