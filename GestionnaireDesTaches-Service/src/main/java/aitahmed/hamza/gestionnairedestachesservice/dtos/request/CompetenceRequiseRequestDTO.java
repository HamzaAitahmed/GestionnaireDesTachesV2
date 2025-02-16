package aitahmed.hamza.gestionnairedestachesservice.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompetenceRequiseRequestDTO {
    private String nom;
    private String niveau;
    private Integer competenceId;
    private Integer listCompetencesRequiseId;
}
