package hu.elte.inf.orarend.persistence.models;
import javax.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "SUBJECTS")
@NoArgsConstructor
@AllArgsConstructor
public class Subjects {

    @Id
    @Column(name="ID")
    private long id;

    @Column(name="CODE", nullable=false, length=100)
    private String code;

    @Column(name="NAME", nullable=false, length=1000)
    private String name;
}