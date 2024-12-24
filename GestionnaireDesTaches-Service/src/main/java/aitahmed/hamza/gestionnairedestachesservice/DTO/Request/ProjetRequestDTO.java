package aitahmed.hamza.gestionnairedestachesservice.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetRequestDTO {
    private String nom;
    private String client;
    private String description;
    private String statut;
    private double budget;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Integer idChefProjet;
    private Integer idEquipeDeProjet;
}
