package aitahmed.hamza.gestionnairedestachesservice.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatutAvecDateRequestDTO {
    private String statut;
    private LocalDate dateDeModification;
    private Integer idHistoriqueStatut;
}
