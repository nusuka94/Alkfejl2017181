package hu.elte.inf.orarend.persistence.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TIMETABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="timetable_course",joinColumns = @JoinColumn(name="timetable_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id"))
    private List<Courses> courses;

    @JoinColumn
    @ManyToOne(targetEntity = User.class)
    private User owner;
}