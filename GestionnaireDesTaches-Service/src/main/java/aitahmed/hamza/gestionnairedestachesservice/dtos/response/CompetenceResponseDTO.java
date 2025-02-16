package aitahmed.hamza.gestionnairedestachesservice.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompetenceResponseDTO {
    private Integer id;
    private String nom;
}
