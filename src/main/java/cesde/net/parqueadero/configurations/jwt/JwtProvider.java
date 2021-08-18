package cesde.net.parqueadero.configurations.jwt;

import cesde.net.parqueadero.data.model.PrincipalUser;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken (Authentication authentication) {
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();

        return Jwts.builder().setSubject(principalUser.getDni())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.ES512, secret)
                .compact();
    }

    public String getDniFromToken (String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
                .getBody().getSubject();
    }

    public Boolean validateToken (String token) {
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
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
}
