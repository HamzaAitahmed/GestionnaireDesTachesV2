package aitahmed.hamza.gestionnairedestachesservice.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequestDTO {
    private LocalDate dateLu;
    private boolean lu;
    private String titre,message;
    private Integer idRecepteur;
}
