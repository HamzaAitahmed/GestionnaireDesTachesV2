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
public class ProjetRequestDTO {
    private String nom;
    private double budget;
    private String client;
    private String description;
    private String statut;
    private LocalDate dateDeCreation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Integer chefProjetId; // ID du chef de projet
    private Integer equipeDuProjetId; // ID de l'équipe associée
    private Integer listMesCompetencesId;
    private List<Integer> lesTachesDeProjetIds; // IDs des membres de l'équipe
}
