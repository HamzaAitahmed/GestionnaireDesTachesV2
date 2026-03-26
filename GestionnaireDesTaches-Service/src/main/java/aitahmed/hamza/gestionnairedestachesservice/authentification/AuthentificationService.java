package aitahmed.hamza.gestionnairedestachesservice.authentification;

import aitahmed.hamza.gestionnairedestachesservice.constants.Constants;
import aitahmed.hamza.gestionnairedestachesservice.dtos.request.ConnecterRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.request.InscriptionRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.ConnecterResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.TokenResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.UtilisateurResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.mappers.UtilisateurMapper;
import aitahmed.hamza.gestionnairedestachesservice.services.UtilisateurService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthentificationService {

    @Value("${cookie.secure}")
    private boolean cookieSecure;

    @Value("${cookie.http-only}")
    private boolean httpOnly;

    private final UtilisateurService utilisateurService;
    private final UtilisateurMapper utilisateurMapper; ;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    AuthentificationService (AuthenticationManager authenticationManager, JwtService jwtService, UtilisateurService utilisateurService, UtilisateurMapper utilisateurMapper) {
        this.authenticationManager = authenticationManager;
        this.utilisateurService = utilisateurService;
        this.utilisateurMapper = utilisateurMapper;
        this.jwtService = jwtService;
    }

    public ConnecterResponseDTO connexion(ConnecterRequestDTO ConnecterRequestDTO, HttpServletResponse response) {
        try {
            Utilisateur utilisateur = utilisateurService.getUtilisateurByEmail(ConnecterRequestDTO.getEmail());
            if (utilisateur == null) {
                throw new RuntimeException("Email or password is incorrect");
            }

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(ConnecterRequestDTO.getEmail(), ConnecterRequestDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            CustomUserDetails authCustomeUtilisateur = (CustomUserDetails) authentication.getPrincipal();
            Utilisateur authUtilisateur = authCustomeUtilisateur.getUtilisateur();

            String accessToken = jwtService.generateAccessToken(authUtilisateur);
            String refreshToken = jwtService.generateRefreshToken(authUtilisateur);
            setRefreshTokenInCookies(refreshToken, response);

            TokenResponseDTO tokenReponse = new TokenResponseDTO(accessToken);

            UtilisateurResponseDTO utilisateurResponse = utilisateurMapper.UtilisateurToUtilisateurResponseDTO(utilisateur);

            jwtService.saveToken(authUtilisateur, refreshToken);
            return new ConnecterResponseDTO( tokenReponse, utilisateurResponse);
        } catch (Exception e) {
            throw new RuntimeException("Authentication failed");
        }
    }

    public void deconnexion(HttpServletRequest request, HttpServletResponse response) {
        String refreshToken = getRefreshTokenFromCookies(request);
        jwtService.revokeToken(refreshToken);
        deleteRefreshTokenInCookies(response);
    }

    public void enregister(InscriptionRequestDTO inscriptionRequestDTO) {

        if (utilisateurService.getUtilisateurByEmail(inscriptionRequestDTO.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        Utilisateur utilisateur = utilisateurMapper.InscriptionRequestDTOtoUtilisateur(inscriptionRequestDTO);

        utilisateurService.creerUtilisateur(utilisateur);
    }

    public TokenResponseDTO refresh(HttpServletRequest request, HttpServletResponse response) {
        String refreshToken = getRefreshTokenFromCookies(request);

        String email = jwtService.extractEmail(refreshToken);
        Utilisateur utilisateur =  utilisateurService.getUtilisateurByEmail(email);

        // Validate in DB
        jwtService.isTokenValid(refreshToken, utilisateur );

        // Generate new tokens
        String newAccessToken = jwtService.generateAccessToken(utilisateur);
        String newRefreshToken = jwtService.generateRefreshToken(utilisateur);

        // Rotation
        jwtService.revokeToken(refreshToken);
        jwtService.saveToken(utilisateur, newRefreshToken);

        setRefreshTokenInCookies(newRefreshToken, response);

        return new TokenResponseDTO(newAccessToken);
    }

    public String getRefreshTokenFromCookies(HttpServletRequest request) {
        return Arrays.stream(request.getCookies())
                .filter(c -> Constants.REFRESH_TOKEN.equals(c.getName()))
                .map(Cookie::getValue)
                .findFirst()
                .orElse(null);
    }

    public void setRefreshTokenInCookies(String refreshToken, HttpServletResponse response) {
        Cookie cookie = new Cookie(Constants.REFRESH_TOKEN, refreshToken);
        cookie.setHttpOnly(httpOnly);
        cookie.setSecure(cookieSecure);
        cookie.setPath(Constants.REFRESH_COOKIE_PATH);
        cookie.setMaxAge((int) (jwtService.refreshtokenTime/100)); // 30 days
        cookie.setAttribute("SameSite", "Strict");

        response.addCookie(cookie);
    }

    public void deleteRefreshTokenInCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie(Constants.REFRESH_TOKEN, null);
        cookie.setHttpOnly(httpOnly);
        cookie.setSecure(cookieSecure);
        cookie.setPath(Constants.REFRESH_COOKIE_PATH);
        cookie.setMaxAge(0);

        response.addCookie(cookie);

    }
}
