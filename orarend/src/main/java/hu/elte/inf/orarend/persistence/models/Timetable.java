package hu.elte.inf.orarend.persistence.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TIMETABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;
    
    @JoinColumn
    @ManyToOne(targetEntity = Courses.class)
    private Courses course;

    @JoinColumn
    @ManyToOne(targetEntity = User.class)
    private User owner;
}