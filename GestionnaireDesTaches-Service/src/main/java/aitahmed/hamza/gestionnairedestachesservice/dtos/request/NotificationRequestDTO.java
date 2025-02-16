package aitahmed.hamza.gestionnairedestachesservice.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequestDTO {
    private LocalDate dateLu;
    private boolean lu;
    private String titre,message;
    private Integer idRecepteur;
}
