package aitahmed.hamza.gestionnairedestachesservice.mappers;

import aitahmed.hamza.gestionnairedestachesservice.dtos.request.ProjetRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.ProjetResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.entity.Equipe;
import aitahmed.hamza.gestionnairedestachesservice.entity.Projet;
import aitahmed.hamza.gestionnairedestachesservice.entity.Tache;
import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.services.EquipeService;
import aitahmed.hamza.gestionnairedestachesservice.services.UtilisateurService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProjetMapper {
    private final UtilisateurService utilisateurService;
    private final EquipeService equipeService;

    ProjetMapper(UtilisateurService utilisateurService, EquipeService equipeService) {
        this.utilisateurService = utilisateurService;
        this.equipeService = equipeService;
    }

    public Projet ProjetRequestDTOtoProjet(ProjetRequestDTO dto) {
        Projet projet = new Projet();
        projet.setId(null);
        projet.setNom(dto.getNom());
        projet.setBudget(dto.getBudget());
        projet.setClient(dto.getClient());
        projet.setDescription(dto.getDescription());
        projet.setDateDeCreation(dto.getDateDeCreation());
        projet.setDateDebut(dto.getDateDebut());
        projet.setDateFin(dto.getDateFin());

        if (dto.getChefProjetId() != null) {
//            Utilisateur chefProjet = new Utilisateur();
//            chefProjet.setId(dto.getChefProjetId());

            Utilisateur chefProjet = utilisateurService.getUtilisateurById(dto.getChefProjetId());
            projet.setChefProjet(chefProjet);
        }

        if (dto.getEquipeDuProjetId() != null) {
//            Equipe equipe = new Equipe();
//            equipe.setId(dto.getEquipeDuProjetId());

            Equipe equipe = equipeService.getEquipeById(dto.getEquipeDuProjetId());
            projet.setEquipeDuProjet(equipe);
        }

        return projet;
    }

    public ProjetResponseDTO ProjettoProjetResponseDTO(Projet projet) {
        ProjetResponseDTO dto = new ProjetResponseDTO();
        dto.setId(projet.getId());
        dto.setNom(projet.getNom());
        dto.setBudget(projet.getBudget());
        dto.setClient(projet.getClient());
        dto.setDescription(projet.getDescription());
        dto.setDateDeCreation(projet.getDateDeCreation());
        dto.setDateDebut(projet.getDateDebut());
        dto.setDateFin(projet.getDateFin());

        if (projet.getChefProjet() != null) {
            dto.setChefProjetId(projet.getChefProjet().getId());
        }
        if (projet.getEquipeDuProjet() != null) {
            dto.setEquipeDuProjetId(projet.getEquipeDuProjet().getId());
        }

        if (projet.getLesTachesDeProjet() != null) {
            dto.setLesTachesDeProjetIds(projet.getLesTachesDeProjet()
                    .stream()
                    .map(Tache::getId)
                    .collect(Collectors.toList()));
        }

        return dto;
    }
}

