package aitahmed.hamza.gestionnairedestachesservice.DTO.Response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TacheResponseDTO {
    private Integer id;
    private String nom;
    private String statutTache;
    private String priorite;
    private LocalDate dateDeCreation;
    private LocalDate dateDebut, dateFin;
    private String description;
    private Integer idAssigneurDeTache;
    private Integer idProjetDeTache;
    private Integer idHistoriqueStatut;
}
