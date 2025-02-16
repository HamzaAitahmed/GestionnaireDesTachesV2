package aitahmed.hamza.gestionnairedestachesservice.dtos.response;

import aitahmed.hamza.gestionnairedestachesservice.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class UtilisateurResponseDTO {
    private Integer id;
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
    private Integer listMesCompetencesId;       // ID de la liste des compétences
    private List<Integer> mesProjetsIds;        // IDs des projets associés
    private List<Integer> mesTachesIds;         // IDs des tâches associées
    private List<Integer> mesEquipesIds;        // IDs des équipes où l'utilisateur est chef
    private List<Integer> membreDansLEquipeIds; // IDs des équipes où l'utilisateur est membre
}
