package cesde.net.parqueadero.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Car {

    @Id
    @Column(name = "dni_car")
    private String dniCar;

    @JoinColumn(name = "fk_owner")
    @OneToOne
    private Owner owner;

    @JoinColumn(name = "fk_owner")
    @OneToOne
    private Contract contract;
}
