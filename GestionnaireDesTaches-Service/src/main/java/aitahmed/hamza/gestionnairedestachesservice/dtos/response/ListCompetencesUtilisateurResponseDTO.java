package aitahmed.hamza.gestionnairedestachesservice.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ListCompetencesUtilisateurResponseDTO {
    private Integer id;
    private Integer utilisateurId;
    private List<Integer> lesCompetencesUtilisateurIds; // IDs des membres de l'équipe
}
