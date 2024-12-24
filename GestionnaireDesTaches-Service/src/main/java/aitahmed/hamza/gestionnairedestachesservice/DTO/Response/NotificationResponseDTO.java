package aitahmed.hamza.gestionnairedestachesservice.DTO.Response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class NotificationResponseDTO {
    private Integer Id;
    private LocalDate dateDeCreation, dateLu;
    private boolean lu;
    private String titre,message;
    private Integer idRecepteur;
}
