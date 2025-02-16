package aitahmed.hamza.gestionnairedestachesservice.mappers;

import aitahmed.hamza.gestionnairedestachesservice.dtos.request.TacheRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.TacheResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.entity.HistoriqueStatut;
import aitahmed.hamza.gestionnairedestachesservice.enumeration.Priorite;
import aitahmed.hamza.gestionnairedestachesservice.enumeration.StatutTache;
import aitahmed.hamza.gestionnairedestachesservice.services.HistoriqueStatutService;
import aitahmed.hamza.gestionnairedestachesservice.services.ProjetService;
import org.springframework.stereotype.Component;
import aitahmed.hamza.gestionnairedestachesservice.entity.Projet;
import aitahmed.hamza.gestionnairedestachesservice.entity.Tache;
import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.services.UtilisateurService;

import java.util.stream.Collectors;

@Component
public class TacheMapper {

    private final ProjetService projetService;
    private final UtilisateurService utilisateurService;
    private final HistoriqueStatutService historiqueStatutService;

    // Injection des services via le constructeur
    public TacheMapper(ProjetService projetService, UtilisateurService utilisateurService, HistoriqueStatutService historiqueStatutService) {
        this.projetService = projetService;
        this.utilisateurService = utilisateurService;
        this.historiqueStatutService = historiqueStatutService;
    }

    // Conversion de TacheRequestDTO vers Tache
    public Tache TacheRequestDTOtoTache(TacheRequestDTO dto) {
        Tache tache = new Tache();
        tache.setId(null);
        tache.setNom(dto.getNom());
        tache.setDescription(dto.getDescription());
        tache.setStatutTache(StatutTache.valueOf(dto.getStatutTache())); // Conversion String -> Enum
        tache.setPriorite(Priorite.valueOf(dto.getPriorite())); // Conversion String -> Enum
        tache.setDateDeCreation(dto.getDateDeCreation());
        tache.setDateDebut(dto.getDateDebut());
        tache.setDateFin(dto.getDateFin());

        // Récupération des objets associés via les services
        if (dto.getProjetDeTacheId() != null) {
            Projet projet = projetService.getProjetById(dto.getProjetDeTacheId());
            tache.setProjetDeTache(projet);
        }

        if (dto.getAssigneurDeTacheId() != null) {
            Utilisateur assigneur = utilisateurService.getUtilisateurById(dto.getAssigneurDeTacheId());
            tache.setAssigneurDeTache(assigneur);
        }

        if (dto.getHistoriqueDeLaTacheId() != null) {
            HistoriqueStatut historique = historiqueStatutService.getHistoriqueStatutById(dto.getHistoriqueDeLaTacheId());
            tache.setHistoriqueDeLaTache(historique);
        }

        return tache;
    }

    // Conversion de Tache vers TacheResponseDTO
    public TacheResponseDTO TachetoTacheResponseDTO(Tache tache) {
        TacheResponseDTO dto = new TacheResponseDTO();
        dto.setId(tache.getId());
        dto.setNom(tache.getNom());
        dto.setDescription(tache.getDescription());
        dto.setStatutTache(tache.getStatutTache().name()); // Conversion Enum -> String
        dto.setPriorite(tache.getPriorite().name()); // Conversion Enum -> String
        dto.setDateDeCreation(tache.getDateDeCreation());
        dto.setDateDebut(tache.getDateDebut());
        dto.setDateFin(tache.getDateFin());

        // Récupération des IDs des objets associés
        if (tache.getProjetDeTache() != null) {
            dto.setProjetDeTacheId(tache.getProjetDeTache().getId());
        }

        if (tache.getAssigneurDeTache() != null) {
            dto.setAssigneurDeTacheId(tache.getAssigneurDeTache().getId());
        }

        if (tache.getHistoriqueDeLaTache() != null) {
            dto.setHistoriqueDeLaTacheId(tache.getHistoriqueDeLaTache().getId());
        }

        return dto;
    }
}
