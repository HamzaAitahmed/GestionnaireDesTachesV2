package aitahmed.hamza.gestionnairedestachesservice.DTO.Response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MessageResponseDTO {
    private Integer id;
    private LocalDate dateDeCreation, dateEnvoyer, dateRecever, dateLu;
    private boolean lu;
    private String titre,message;
    private Integer idEmmetteur;
    private Integer idRecepteur;
}
