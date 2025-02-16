package aitahmed.hamza.gestionnairedestachesservice.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompetenceRequiseResponseDTO {
    private Integer id;
    private String nom;
    private String niveau;
    private Integer competenceId;
    private Integer listCompetencesRequiseId;
}
