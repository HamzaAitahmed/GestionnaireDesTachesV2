package aitahmed.hamza.gestionnairedestachesservice.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EquipeRequestDTO {
    private String nom;
    private Integer idChefEquipe;
}
