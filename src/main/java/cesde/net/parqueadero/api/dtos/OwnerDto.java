package cesde.net.parqueadero.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class OwnerDto {

    @NotBlank
    private String dni;

    @NotBlank
    private String name;
}
