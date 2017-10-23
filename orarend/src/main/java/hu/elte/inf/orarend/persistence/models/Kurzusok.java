package hu.elte.inf.orarend.persistence.models;
import javax.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kurzusok {
    @Id
    @Column(name="id")
    private long id;

    @Column(name="targy_id", nullable = false)
    private long targy_id;

    @Column(name="oktato", length=100)
    private String oktato;

    @Column(name="nap", length=20)
    private String nev;

    @Column(name="idopont_tol", length=20)
    private String idopont_tol;

    @Column(name="idopont_ig", length=20)
    private String idopont_ig;

    @Column(name="terem_id", nullable = false)
    private long terem_id;

    @Column(name="oratipus", length=20)
    private String oratipus;

    @Column(name="csoport")
    private long csoport;
}
