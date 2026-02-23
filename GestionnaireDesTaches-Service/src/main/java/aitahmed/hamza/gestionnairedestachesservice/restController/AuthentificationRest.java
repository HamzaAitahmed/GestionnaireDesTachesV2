package aitahmed.hamza.gestionnairedestachesservice.restController;

import aitahmed.hamza.gestionnairedestachesservice.authentification.AuthentificationService;
import aitahmed.hamza.gestionnairedestachesservice.dtos.request.ConnecterRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.request.InscriptionRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.request.TokenRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.TokenResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth/")
public class AuthentificationRest {
    private final AuthentificationService authentificationService;

    AuthentificationRest (AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }

    @PostMapping(path = "/inscription")
    public ResponseEntity<?> createNewUser(@RequestBody InscriptionRequestDTO InscriptionRequestDTO) {

        authentificationService.enregister(InscriptionRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("status", "success","message", "User registered successfully" ));
    }


    @PostMapping(path = "/connecter")
    public ResponseEntity<?> login(@RequestBody ConnecterRequestDTO ConnecterRequestDTO) {

        try {
            TokenResponseDTO response = authentificationService.connexion(ConnecterRequestDTO);
            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }

    @PostMapping("/deconnecter")
    public ResponseEntity<Map<String, String>> logout(@RequestBody TokenRequestDTO tokenRequest) {

        authentificationService.deconnexion(tokenRequest.getRefreshToken());

        return ResponseEntity.ok(
                Map.of("message", "Logged out successfully")
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponseDTO> refresh( @RequestBody TokenRequestDTO tokenRequestDTO) {

        return ResponseEntity.ok(
                authentificationService.refresh(tokenRequestDTO)
        );
    }

}
