package cesde.net.parqueadero.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtDto {

    private String token;
    private String bearer = "Bearer";
    private String dni;
    private Collection<? extends GrantedAuthority> authorities;

}
