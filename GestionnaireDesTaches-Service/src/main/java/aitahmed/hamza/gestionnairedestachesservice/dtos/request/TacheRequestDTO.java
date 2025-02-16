package aitahmed.hamza.gestionnairedestachesservice.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class TacheRequestDTO {
    private String nom;
    private String description;
    private String statutTache;
    private String priorite;
    private LocalDate dateDeCreation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Integer historiqueDeLaTacheId;
    private Integer projetDeTacheId; // ID du projet associé
    private Integer assigneurDeTacheId; // ID de l'utilisateur assigneur
}
