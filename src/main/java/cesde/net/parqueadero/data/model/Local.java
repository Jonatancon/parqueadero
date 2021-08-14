package cesde.net.parqueadero.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "available_space")
    private Integer availableSpace;

    @Column(name = "reserved_places")
    private Integer reservedPlaces;

    @Column(name = "occupied_places")
    private Integer occupiedPlaces;

    @Column(name = "total_places")
    private Integer totalPlaces;
}
