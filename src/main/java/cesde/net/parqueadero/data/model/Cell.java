package cesde.net.parqueadero.data.model;

import lombok.Builder;

import javax.persistence.*;

@Entity
public class Cell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private boolean ocupado;

    @Column(nullable = true)
    private boolean reserved;

    public Cell() {
    }

    public Cell(Long id, boolean ocupado, boolean reserved) {
        this.id = id;
        this.ocupado = ocupado;
        this.reserved = reserved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
