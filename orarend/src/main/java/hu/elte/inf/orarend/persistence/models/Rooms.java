package hu.elte.inf.orarend.persistence.models;
import javax.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "ROOMS")
@NoArgsConstructor
@AllArgsConstructor
public class Rooms {
    @Id
    @Column(name="ID")
    private long id;

    @Column(name="ROOM", nullable=false, length=100)
    private String room;
}
