package dev.bearded.apigesthor.security;

import dev.bearded.apigesthor.model.Usuario;
import dev.bearded.apigesthor.repository.UsuarioRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario encontrado = usuarioRepository.findByEmail(s);
        if (encontrado == null) {
            throw new UsernameNotFoundException("usuario não encontrado");
        }
        return new UsuarioDetails(encontrado);
    }
}
