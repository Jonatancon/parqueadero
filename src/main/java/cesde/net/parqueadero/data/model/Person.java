package cesde.net.parqueadero.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty
    private String dni;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    @JoinColumn(name = "fk_local")
    @ManyToOne(fetch = FetchType.LAZY)
    private Local local;

    @ManyToMany
    @JoinTable(name = "user_rol", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> rols = new HashSet<>();

    public Person(String dni, String name, String password, Local local) {
        this.dni = dni;
        this.name = name;
        this.password = password;
        this.local = local;
    }
}
