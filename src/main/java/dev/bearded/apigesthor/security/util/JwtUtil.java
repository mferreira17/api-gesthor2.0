package dev.bearded.apigesthor.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dev.bearded.apigesthor.model.Usuario;
import dev.bearded.apigesthor.security.UsuarioDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.time.ZoneId;
import java.util.*;

public class JwtUtil {


    private final static String SECRET = "api-segredo";

    public String createToken(UsuarioDetails usuarioDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, usuarioDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }


    public String generateToken(String username){
        return JWT.create().
                withIssuer("gestor").
                withClaim("user", username).
                withExpiresAt(Date.from(Instant.now().plusSeconds(7200))).
                sign(Algorithm.HMAC256(SECRET));
    }


    public static void main(String[] args) {

        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        List<String> values = Arrays.asList("MEU TOKEN","TESTE", "VALENDO");

        Map<String, String> claims = new HashMap<>();
        claims.put("user",  new Usuario("Márcio Ferreira", "mwferreira17@gmail.com", "teste").toString());

        Instant instant = Instant.now();
        instant.atZone(ZoneId.of("UTC"));

        System.out.println(instant);

        System.out.println(Instant.now().plusSeconds(7200));

        System.out.println(JWT.create().withIssuer("Márcio Ferreira").
                withClaim("user", claims).sign(algorithm));

    }

}
