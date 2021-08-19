package cesde.net.parqueadero.api.dtos;

import cesde.net.parqueadero.data.model.Contract;
import cesde.net.parqueadero.data.model.Owner;

import javax.validation.constraints.NotBlank;

public class CarDto {
    @NotBlank
    private String dniCar;
    private Owner owner;
    private Contract contract;

    public CarDto(@NotBlank String dniCar, Owner owner, Contract contract) {
        this.dniCar = dniCar;
        this.owner = owner;
        this.contract = contract;
    }

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
