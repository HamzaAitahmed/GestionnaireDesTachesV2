package aitahmed.hamza.gestionnairedestachesservice.authentification;

import aitahmed.hamza.gestionnairedestachesservice.constants.Constants;
import aitahmed.hamza.gestionnairedestachesservice.services.UtilisateurService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    UtilisateurService utilisateurService;
    UserDetailsService userDetailsService;
    JwtService jwtService;

    JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService, UtilisateurService utilisateurService) {
        this.userDetailsService = userDetailsService;
        this.utilisateurService = utilisateurService;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {


        String authHeader = request.getHeader(Constants.HEADER_AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith(Constants.HEADER_BEARER)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(Constants.HEADER_BEARER.length());

        String email = jwtService.extractEmail(token);

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            CustomUserDetails customUserDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(email);

            if (jwtService.isTokenValid(token, customUserDetails.getUtilisateur())) {

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                customUserDetails, null, customUserDetails.getAuthorities()
                        );

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
