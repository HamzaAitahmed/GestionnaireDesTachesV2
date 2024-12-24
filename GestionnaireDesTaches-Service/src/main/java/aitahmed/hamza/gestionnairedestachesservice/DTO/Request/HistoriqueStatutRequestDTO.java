package aitahmed.hamza.gestionnairedestachesservice.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoriqueStatutRequestDTO {
    private Integer idTache;
}
