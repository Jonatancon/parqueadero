package cesde.net.parqueadero.configurations.jwt;

import cesde.net.parqueadero.api.dtos.JwtDto;
import cesde.net.parqueadero.data.model.PrincipalUser;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken (Authentication authentication) {
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        List<String> roles = principalUser.getAuthorities().stream().map(
                GrantedAuthority::getAuthority).collect(Collectors.toList());

        return Jwts.builder().setSubject(principalUser.getDni())
                .setIssuedAt(new Date())
                .claim("roles", roles)
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    public String getDniFromToken (String token) {
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token)
                .getBody().getSubject();
    }

    public Boolean validateToken (String token) {
        try{
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e) {
            logger.error("Token mal formado");
        }catch (UnsupportedJwtException e) {
            logger.error("Token no Soportado");
        }catch (ExpiredJwtException e) {
            logger.error("Token Expirado");
        }catch (IllegalArgumentException e) {
            logger.error("Token Ilegal");
        }catch (SignatureException e) {
            logger.error("Fail en la firma");
        }
        return false;
    }

    public String refreshToken (JwtDto jwtDto) throws ParseException {
        JWT jwt = JWTParser.parse(jwtDto.getToken());
        JWTClaimsSet claimsSet = jwt.getJWTClaimsSet();
        String dni = claimsSet.getSubject();
        List<String> roles = (List<String>) claimsSet.getClaim("roles");

        return Jwts.builder().setSubject(dni)
                .setIssuedAt(new Date())
                .claim("roles", roles)
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }
}
