package hu.elte.inf.orarend.persistence.models;

import javax.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "HALLGATO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Felhasznalo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    
    @Column(name="felhasznalonev")
    private String felhasznalonev;
    
    @Column(name="neptun",nullable=false, unique = true)
    private String neptun;
    
    @Column(name="jelszo")
    private String jelszo;
    
    @Column(name="role", nullable = false,unique=true)
    @Enumerated(EnumType.STRING)
    private Role role;
    public enum Role {
        GUEST, USER, ADMIN
    }
}
