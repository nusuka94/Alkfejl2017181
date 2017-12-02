package hu.elte.inf.orarend.persistence.models;

import javax.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;
    
    @Column(name="USERNAME")
    private String username;
    
    @Column(name="PASSWORD")
    private String password;
    
    @Column(name="ROLE", nullable = false,unique=true)
    @Enumerated(EnumType.STRING)
    private Role role;
    public enum Role {
        GUEST, USER, ADMIN
    }
}
