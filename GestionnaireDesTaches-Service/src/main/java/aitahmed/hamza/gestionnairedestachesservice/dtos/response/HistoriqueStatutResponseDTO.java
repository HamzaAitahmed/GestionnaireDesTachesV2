package aitahmed.hamza.gestionnairedestachesservice.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoriqueStatutResponseDTO {
    private Integer id;
    private Integer tacheDeHistoriqueId;
    private List<Integer> listDesStatutsIds;    // IDs des membres de l'équipe
}

