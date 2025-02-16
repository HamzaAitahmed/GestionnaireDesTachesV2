package aitahmed.hamza.gestionnairedestachesservice.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class UtilisateurRequestDTO {
    private String email;
    private double salaire;
    private String nom;
    private String prenom;
    private String username;
    private String gender;
    private LocalDate dateOfBirth;
    private LocalDate dateInscription;
    private int anneeExperience;
    private String role;
    private String profilePicture;
    private Integer listMesCompetencesId;
    private List<Integer> mesProjetsIds;    // IDs des membres de l'équipe
    private List<Integer> mesTachesIds;     // IDs des membres de l'équipe
    private List<Integer> mesEquipesIds;    // IDs des membres de l'équipe
    private List<Integer> membreDansLEquipeIds; // IDs des membres de l'équipe
}
