package cesde.net.parqueadero.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "fk_car")
    @ManyToOne
    private Car car;

    @JoinColumn(name = "fk_cell")
    @ManyToOne
    private Cell cell;

    @Column(name = "start_date")
    //@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startDate;

    @Column(name = "final_date")
    //@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String finalDate;

    private Boolean active;

    public ParkingLot(Car car, Cell cell, String startDate, String finalDate, Boolean active) {
        this.car = car;
        this.cell = cell;
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.active = active;
    }

    public ParkingLot(Long id, Car car, Cell cell, String startDate, String finalDate, Boolean active) {
        this.id = id;
        this.car = car;
        this.cell = cell;
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
