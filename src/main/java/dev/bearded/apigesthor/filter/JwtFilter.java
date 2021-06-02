package dev.bearded.apigesthor.filter;

import dev.bearded.apigesthor.security.UsuarioDetails;
import dev.bearded.apigesthor.security.UsuarioDetailsService;
import dev.bearded.apigesthor.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter{

    private final UsuarioDetailsService usuarioDetailsService;
    private final JwtUtil jwtUtil;


    public JwtFilter(UsuarioDetailsService usuarioDetailsService, JwtUtil jwtUtil) {
        this.usuarioDetailsService = usuarioDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String jwtRequest = jwtUtil.parseTokenFromRequest(request);
            if (jwtUtil.validateJwtToken(jwtRequest)){
            }
        }catch (Exception e){

        }


        /*var authorizationHeader = request.getHeader("Authorization");
        var username = "";

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            username = jwtUtil.extractUsernameFromToken(authorizationHeader);
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() != null){
            UsuarioDetails usuarioDetails = (UsuarioDetails) usuarioDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuarioDetails, usuarioDetails.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }*/

        filterChain.doFilter(request, response);
    }
}
