package cesde.net.parqueadero.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Car {

    @Id
    @Column(name = "dni_car")
    private String dniCar;

    @JoinColumn(name = "fk_owner")
    @ManyToOne
    private Owner owner;

    @JoinColumn(name = "fk_contract")
    @OneToOne
    private Contract contract;

    public String getDniCar() {
        return dniCar;
    }

    public void setDniCar(String dniCar) {
        this.dniCar = dniCar;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
