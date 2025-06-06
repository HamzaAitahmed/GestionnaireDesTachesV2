package aitahmed.hamza.gestionnairedestachesservice.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EquipeResponseDTO {
    private Integer id;
    private String nom;
    private LocalDate dateDeCreation;
    private Integer chefEquipeId; // ID du chef d'équipe
    private List<Integer> lesProjetsDEquipeIds; // IDs des membres de l'équipe
    private List<Integer> lesMembresDEquipeIds; // IDs des membres de l'équipe
}
