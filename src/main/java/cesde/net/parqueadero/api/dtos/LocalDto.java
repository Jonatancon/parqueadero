package cesde.net.parqueadero.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class LocalDto {

    private Long id;

    @NotBlank
    @Min(0)
    private Integer availableSpace;

    @NotBlank
    @Min(0)
    private Integer reservedPlaces;

    @NotBlank
    @Min(0)
    private Integer occupiedPlaces;

    @NotBlank
    @Min(0)
    private Integer totalPlaces;

}
