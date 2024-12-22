package aitahmed.hamza.gestionnairedestachesservice.DTO;

import aitahmed.hamza.gestionnairedestachesservice.DTO.Request.CompetenceRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.DTO.Request.EquipeRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.DTO.Request.ProjetRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.DTO.Request.TacheRequestDTO;
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
}
