package aitahmed.hamza.gestionnairedestachesservice.authentification;

import aitahmed.hamza.gestionnairedestachesservice.dtos.request.ConnecterRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.request.InscriptionRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.request.TokenRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.TokenResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.mappers.UtilisateurMapper;
import aitahmed.hamza.gestionnairedestachesservice.services.UtilisateurService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {

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

    public TokenResponseDTO connexion(ConnecterRequestDTO ConnecterRequestDTO) {
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

            jwtService.saveToken(authUtilisateur, refreshToken);
            return new TokenResponseDTO(accessToken, refreshToken);
        } catch (Exception e) {
            throw new RuntimeException("Authentication failed");
        }
    }

    public void deconnexion(String refreshToken) {
        jwtService.revokeToken(refreshToken);
    }

    public void enregister(InscriptionRequestDTO inscriptionRequestDTO) {

        if (utilisateurService.getUtilisateurByEmail(inscriptionRequestDTO.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        Utilisateur utilisateur = utilisateurMapper.InscriptionRequestDTOtoUtilisateur(inscriptionRequestDTO);

        utilisateurService.creerUtilisateur(utilisateur);
    }

    public TokenResponseDTO refresh(TokenRequestDTO tokenRequestDTO) {

        String refreshToken = tokenRequestDTO.getRefreshToken();
        String email = jwtService.extractEmail(refreshToken);
        Utilisateur utilisateur =  utilisateurService.getUtilisateurByEmail(email);

        // Validate in DB
        jwtService.isTokenValid(tokenRequestDTO.getRefreshToken(), utilisateur );

        // Generate new tokens
        String newAccessToken = jwtService.generateAccessToken(utilisateur);
        String newRefreshToken = jwtService.generateRefreshToken(utilisateur);

        // Rotation
        jwtService.revokeToken(refreshToken);
        jwtService.saveToken(utilisateur, newRefreshToken);

        return new TokenResponseDTO(newAccessToken, newRefreshToken);
    }
}
