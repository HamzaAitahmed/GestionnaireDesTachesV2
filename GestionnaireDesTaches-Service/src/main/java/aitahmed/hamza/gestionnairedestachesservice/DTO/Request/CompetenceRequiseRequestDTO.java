package aitahmed.hamza.gestionnairedestachesservice.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompetenceRequiseRequestDTO {
    private String nom;
    private String niveau;
    private Integer ProjetId;
}
