package aitahmed.hamza.gestionnairedestachesservice.DTO.Response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EquipeResponseDTO {
    private Integer id;
    private String nom;
    private LocalDate dateDeCreation;
    private Integer idChefEquipe;
}
