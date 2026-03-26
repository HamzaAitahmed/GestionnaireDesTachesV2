package aitahmed.hamza.gestionnairedestachesservice.restController;

import aitahmed.hamza.gestionnairedestachesservice.authentification.AuthentificationService;
import aitahmed.hamza.gestionnairedestachesservice.constants.Constants;
import aitahmed.hamza.gestionnairedestachesservice.dtos.request.ConnecterRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.request.InscriptionRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.ConnecterResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.TokenResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthentificationRest {
    private final AuthentificationService authentificationService;

    AuthentificationRest (AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }

    @PostMapping(path = Constants.URL_INSCRIPTION_REST)
    public ResponseEntity<?> createNewUser(@RequestBody InscriptionRequestDTO InscriptionRequestDTO) {

        authentificationService.enregister(InscriptionRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("status", "success","message", "User registered successfully" ));
    }


    @PostMapping(path = Constants.URL_CONNECTER_REST)
    public ResponseEntity<?> login(@RequestBody ConnecterRequestDTO ConnecterRequestDTO, HttpServletResponse response) {

        try {
            ConnecterResponseDTO connecterResponseDTO = authentificationService.connexion(ConnecterRequestDTO, response);
            return ResponseEntity.ok(connecterResponseDTO);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping(Constants.URL_DECONNECTER_REST)
    public ResponseEntity<Map<String, String>> logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(Constants.URL_DECONNECTER_REST);
        authentificationService.deconnexion(request, response);
        return ResponseEntity.ok( Map.of("message", "Logged out successfully") );
    }

    @PostMapping(Constants.URL_REFRESH_REST)
    public ResponseEntity<TokenResponseDTO> refresh(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(Constants.URL_REFRESH_REST);
        try {
            return ResponseEntity.ok( authentificationService.refresh(request, response) );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

    @PostMapping(Constants.URL_REDIRECT_REFRESH_REST)
    public ResponseEntity<TokenResponseDTO> guardsRefresh(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(Constants.URL_REDIRECT_REFRESH_REST);
        try {
            return ResponseEntity.ok( authentificationService.refresh(request, response) );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
