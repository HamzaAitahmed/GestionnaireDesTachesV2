package aitahmed.hamza.gestionnairedestachesservice.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageRequestRequestDTO {
    private LocalDate dateEnvoyer;
    private LocalDate dateRecever;
    private LocalDate dateLu;
    private boolean lu;
    private String titre;
    private String message;
    private Integer idEmmetteur;
    private Integer idRecepteur;
}
