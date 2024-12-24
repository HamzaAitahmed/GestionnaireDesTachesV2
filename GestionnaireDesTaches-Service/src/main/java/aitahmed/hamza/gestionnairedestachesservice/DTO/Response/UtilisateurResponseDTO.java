package aitahmed.hamza.gestionnairedestachesservice.DTO.Response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UtilisateurResponseDTO {
    private Integer id;
    private String email;
    private double salaire;
    private String nom, prenom, username, password, gender;
    private LocalDate dateOfBirth;
    private LocalDate dateInscription;
    private int anneeExpeience;
    private String role;
    private String profilePicture;
}
