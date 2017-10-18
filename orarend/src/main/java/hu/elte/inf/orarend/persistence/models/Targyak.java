package hu.elte.inf.orarend.persistence.models;
import javax.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Targyak {

    @Id
    @Column(name="id")
    private long id;

    @Column(name="kod", nullable=false, length=100)
    private String kod;

    @Column(name="nev", nullable=false, length=1000)
    private String nev;
}