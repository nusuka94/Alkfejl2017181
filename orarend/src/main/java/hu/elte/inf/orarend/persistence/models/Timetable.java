package hu.elte.inf.orarend.persistence.models;

import javax.persistence.*;

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
    
    @JoinColumn
    @ManyToOne(targetEntity = Courses.class)
    private List<Courses> course;

    @JoinColumn
    @ManyToOne(targetEntity = User.class)
    private User owner;
}