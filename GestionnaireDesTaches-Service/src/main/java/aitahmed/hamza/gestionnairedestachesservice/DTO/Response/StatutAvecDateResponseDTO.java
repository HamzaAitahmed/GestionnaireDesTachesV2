package aitahmed.hamza.gestionnairedestachesservice.DTO.Response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class StatutAvecDateResponseDTO {
    private Integer id;
    private String statut;
    private LocalDate dateDeModification;
    private Integer idHistoriqueStatut;
}
