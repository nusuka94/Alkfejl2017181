package hu.elte.inf.orarend.persistence.models;

import javax.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hallgato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    
    @Column(name="felhasznalonev")
    private String username;
    
    @Column(name="neptun",nullable=false, unique = true)
    private String neptun;
    
    @Column(name="jelszo")
    private String password;
}
