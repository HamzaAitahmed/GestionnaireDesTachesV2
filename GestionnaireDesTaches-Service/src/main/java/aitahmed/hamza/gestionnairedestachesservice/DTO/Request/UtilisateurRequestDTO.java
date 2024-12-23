package aitahmed.hamza.gestionnairedestachesservice.DTO.Request;

import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
public class UtilisateurRequestDTO {
    private Integer Id;
    private String Email;
    private double Salaire;
    private String Nom, Prenom, Username, Password, Gender;
    private Date DateOfBirth;
    private Date DateInscription, AnneeExpeience;
    private String Role;
    private String ProfilePicture;
    private Collection<ProjetRequestDTO> mesProjetDTOS;
    private Collection<CompetenceRequestDTO> MesCompetence;
    private Collection<TacheRequestDTO> mesTaches;
    private Collection<EquipeRequestDTO> mesEquipeRequestDTOS;
    private Collection<EquipeRequestDTO> membreEquipeRequestDTO;
}
