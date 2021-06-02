package dev.bearded.apigesthor.controller;

import dev.bearded.apigesthor.security.UsuarioDetails;
import dev.bearded.apigesthor.security.UsuarioDetailsService;
import dev.bearded.apigesthor.security.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Teste")
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class LoginController {

    private final JwtUtil jwtUtil;

    private final UsuarioDetailsService usuarioDetailsService;

    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginController(JwtUtil jwtUtil, UsuarioDetailsService usuarioDetailsService) {
        this.jwtUtil = jwtUtil;
        this.usuarioDetailsService = usuarioDetailsService;
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/http://localhost:8081/documentation/swagger-ui/";
    }

    @PostMapping("/auth/dologin")
    public ResponseEntity<?> login(String email, String senha) {

        log.info("Email .: " + email);
        log.info("Senha .: " + senha);
        Authentication authentication = null;

        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, passwordEncoder.encode(senha)));
        } catch (BadCredentialsException exception) {
            exception.printStackTrace();
        }

        UsuarioDetails usuarioDetails = (UsuarioDetails) authentication.getPrincipal();

        return ResponseEntity.ok(jwtUtil.generateToken(usuarioDetails.getUsername()));
    }

}
