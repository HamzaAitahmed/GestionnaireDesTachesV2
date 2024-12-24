package aitahmed.hamza.gestionnairedestachesservice.DTO.Request;

import aitahmed.hamza.gestionnairedestachesservice.DTO.Response.HistoriqueStatutResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.DTO.Response.ProjetResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.DTO.Response.UtilisateurResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class TacheRequestDTO {
    private String nom;
    private String statutTache;
    private String priorite;
    private LocalDate dateDebut, dateFin;
    private String description;
    private Integer idAssigneurDeTache;
    private Integer idProjetDeTache;
    private Integer idHistoriqueStatut;
}
