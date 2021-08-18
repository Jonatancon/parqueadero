package cesde.net.parqueadero.api.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginUser {

    @NotBlank
    private String dni;

    @NotBlank
    private String password;
}
