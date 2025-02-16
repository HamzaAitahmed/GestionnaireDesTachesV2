package aitahmed.hamza.gestionnairedestachesservice.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatutAvecDateResponseDTO {
    private Integer id;
    private String statut;
    private LocalDate dateDeModification;
    private Integer historiqueId;
}
