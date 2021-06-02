package dev.bearded.apigesthor.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.bearded.apigesthor.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JwtUtil {

    @Value("${API_SECRET}")
    private String apiSecret;
/*
    public String createToken(UsuarioDetails usuarioDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, usuarioDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }
*/

    public String generateToken(String username) {
        var token = JWT.create().
                withSubject(username).
                withIssuedAt(new Date()).
                withExpiresAt(Date.from(Instant.now().plusSeconds(7200))).
                sign(Algorithm.HMAC256(apiSecret));
        System.out.println(token);
        return token;
    }

    public String extractUsernameFromToken(String token) {
        return JWT.decode(token).getSubject();
    }

    public String parseTokenFromRequest(HttpServletRequest request){
        String headerAuthorization = request.getHeader("Authorization");
        String parse = "";
        try{
            parse = Stream.of(headerAuthorization).
                    filter(s -> !s.isEmpty() && s.startsWith("Bearer ")).collect(Collectors.joining());
            return parse;
        } catch (Exception e){
            e.printStackTrace();
        }
        return parse;
    }

    public boolean validateJwtToken(String jwtRequest) {
        //return JWT.decode(jwtRequest).e
        return false;
    }

    public static void main(String[] args) {

        // Algorithm algorithm = Algorithm.HMAC256(apiSecret);
        //List<String> values = Arrays.asList("MEU TOKEN","TESTE", "VALENDO");

        Map<String, String> claims = new HashMap<>();

        Usuario usuario = new Usuario("Márcio Ferreira", "mwferreira17@gmail.com", "teste");

        claims.put("username", usuario.getEmail());

        String token = JWT.create().withIssuer("Márcio Ferreira").
                withClaim("user", claims)
                .sign(Algorithm.HMAC256("apisegredo"));

        System.out.println(token);

        DecodedJWT decodedJWT = JWT.decode(token);

        System.out.println(decodedJWT.getClaim("user"));
    }


}
