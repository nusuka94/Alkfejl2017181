package hu.elte.inf.orarend.persistence.repositories;

import hu.elte.inf.orarend.persistence.models.Timetable;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends CrudRepository<Timetable,Long>{
    Timetable findById(long id);
    List<Timetable> findByUserId(long userId);
    void deleteById(long id);

//    @Modifying
//    @Query(value = "insert into timetable_course(timetable_id,course_id) values(:timetableId,:courseId)", nativeQuery = true)
//    void addCourseToTimetable(@Param("timetableId") long tid, @Param("courseId") long cid);

    //void addCourseToTimetable(long tid, long cid);
}
