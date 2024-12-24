package aitahmed.hamza.gestionnairedestachesservice.DTO.Response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ProjetResponseDTO {
    private Integer id;
    private String nom;
    private String client;
    private String description;
    private String statut;
    private double budget;
    private LocalDate dateDeCreation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Integer idChefProjet;
    private Integer idEquipeDeProjet;
}
