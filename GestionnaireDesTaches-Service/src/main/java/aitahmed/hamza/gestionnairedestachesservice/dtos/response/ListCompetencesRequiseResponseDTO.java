package aitahmed.hamza.gestionnairedestachesservice.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ListCompetencesRequiseResponseDTO {
    private Integer id;
    private Integer projetId;
    private List<Integer> lesCompetencesRequiseIds; // IDs des membres de l'équipe
}
