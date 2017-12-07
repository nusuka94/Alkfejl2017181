package hu.elte.inf.orarend.persistence.models;
import javax.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COURSES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courses {

    @Id
    @Column(name="ID")
    private long id;

    @JoinColumn
    @ManyToOne(targetEntity = Subjects.class)
    private Subjects subject;

    @Column(name="INSTRUCTOR", length=1000)
    private String instructor;

    @Column(name="DAY", length=20)
    private String day;

    @Column(name="START_TIME", length=20)
    private String startTime;

    @Column(name="END_TIME", length=20)
    private String endTime;

    @JoinColumn
    @ManyToOne(targetEntity = Rooms.class)
    private Rooms room;

    @Column(name="SUBJECT_TYPE", length=20)
    private String subjectType;

    @Column(name="COURSE_CODE")
    private long courseCode;
}
