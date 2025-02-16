package aitahmed.hamza.gestionnairedestachesservice.restController;

import aitahmed.hamza.gestionnairedestachesservice.dtos.request.ConnecterRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.request.InscriptionRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.mappers.UtilisateurMapper;
import aitahmed.hamza.gestionnairedestachesservice.services.UtilisateurService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/Auth/")
public class AuthentificationRest {
    private final UtilisateurService utilisateurService;
    private final UtilisateurMapper utilisateurMapper; ;
    private final AuthenticationManager authenticationManager;
    private final HttpServletRequest request;

    AuthentificationRest (HttpServletRequest request,AuthenticationManager authenticationManager, UtilisateurService utilisateurService, UtilisateurMapper utilisateurMapper) {
        this.authenticationManager = authenticationManager;
        this.utilisateurService = utilisateurService;
        this.utilisateurMapper = utilisateurMapper;
        this.request = request;
    }

    @PostMapping(path = "/inscription")
    public ResponseEntity<?> createNewUser(@RequestBody InscriptionRequestDTO InscriptionRequestDTO) {
        try {
            Utilisateur utilisateurTest = utilisateurService.getUtilisateurByEmail(InscriptionRequestDTO.getEmail());

            if (utilisateurTest != null) {
                Map<String, String> response = new HashMap<>();
                response.put("status", "error");
                response.put("message", "Email already exists");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            Utilisateur newUtilisateur = utilisateurMapper.InscriptionRequestDTOtoUtilisateur(InscriptionRequestDTO);
            utilisateurService.creerUtilisateur(newUtilisateur);

            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Registration successful, please login");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Registration failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @PostMapping(path = "/connecter")
    public ResponseEntity<?> login(@RequestBody ConnecterRequestDTO ConnecterRequestDTO) {
        try {
            Utilisateur utilisateur = utilisateurService.getUtilisateurByEmail(ConnecterRequestDTO.getEmail());
            if (utilisateur == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email or password is incorrect");
            }
            System.out.println( "utilisateur : " + utilisateur.getEmail() );

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(ConnecterRequestDTO.getEmail(), ConnecterRequestDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            HttpSession session = request.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
            System.out.println("session id " + session.getId());
            return ResponseEntity.ok(utilisateur);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

    @PostMapping("/deconnecter")
    public ResponseEntity<Map<String, String>> logout(HttpServletRequest request) {
        System.out.println("deconnecter : " + request.getSession().getId());
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Détruisez la session
        }
        SecurityContextHolder.clearContext(); // Effacez le contexte de sécurité
        System.out.println("Session invalidated and security context cleared");

        // Return a JSON response
        Map<String, String> response = new HashMap<>();
        response.put("message", "Logged out successfully");
        return ResponseEntity.ok(response);
    }

}
