package cesde.net.parqueadero.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
}
