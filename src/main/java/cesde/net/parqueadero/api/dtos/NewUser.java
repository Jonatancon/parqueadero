package cesde.net.parqueadero.api.dtos;

import cesde.net.parqueadero.data.model.Local;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
public class NewUser {

    @NotBlank
    private String dni;
    @NotBlank
    private String name;
    @NotBlank
    private String password;

    private Local local;

    private Set<String> roles = new HashSet<>();
}
