package aitahmed.hamza.gestionnairedestachesservice.dtos.request;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompetenceUtilisateurRequestDTO {
    private String nom;
    private String niveau;
    private Integer competenceId;
    private Integer listCompetencesUtilisateurId;
}
