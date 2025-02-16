package aitahmed.hamza.gestionnairedestachesservice.mappers;

import aitahmed.hamza.gestionnairedestachesservice.dtos.request.EquipeRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.EquipeResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.entity.Equipe;
import aitahmed.hamza.gestionnairedestachesservice.entity.Projet;
import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.services.ProjetService;
import aitahmed.hamza.gestionnairedestachesservice.services.UtilisateurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipeMapper {
    private final UtilisateurService utilisateurService;
    private final ProjetService projetService;

    public EquipeMapper(UtilisateurService utilisateurService, ProjetService projetService) {
        this.utilisateurService = utilisateurService;
        this.projetService = projetService;
    }

    public Equipe EquipeRequestDTOtoEquipe(EquipeRequestDTO dto) {
        Equipe equipe = new Equipe();
        equipe.setId(null);
        equipe.setNom(dto.getNom());
        equipe.setDateDeCreation(dto.getDateDeCreation());

        if (dto.getChefEquipeId() != null) {
            Utilisateur chefEquipe = utilisateurService.getUtilisateurById(dto.getChefEquipeId());
            equipe.setChefEquipe(chefEquipe);
        }else{
            equipe.setChefEquipe(null);
        }

        if (dto.getLesMembresDEquipeIds() != null && !dto.getLesMembresDEquipeIds().isEmpty()) {
            List<Utilisateur> membres = dto.getLesMembresDEquipeIds().stream()
                    .map(utilisateurService::getUtilisateurById)
                    .collect(Collectors.toList());
            equipe.setLesMembresDEquipe(membres);
        }else{
            equipe.setLesMembresDEquipe(null);
        }

        if (dto.getLesProjetsDEquipeIds() != null && !dto.getLesProjetsDEquipeIds().isEmpty()) {
            List<Projet> projets = dto.getLesProjetsDEquipeIds().stream()
                    .map(projetService::getProjetById)
                    .collect(Collectors.toList());
            equipe.setLesProjetsDEquipe(projets);
        }else {
            equipe.setLesProjetsDEquipe(null);
        }

        return equipe;
    }

    public EquipeResponseDTO EquipeToEquipeResponseDTO(Equipe equipe) {
        EquipeResponseDTO dto = new EquipeResponseDTO();
        dto.setId(equipe.getId());
        dto.setNom(equipe.getNom());
        dto.setDateDeCreation(equipe.getDateDeCreation());

        if (equipe.getChefEquipe() != null) {
            dto.setChefEquipeId(equipe.getChefEquipe().getId());
        }else{
            dto.setChefEquipeId(null);
        }

        if (equipe.getLesMembresDEquipe() != null && !equipe.getLesMembresDEquipe().isEmpty()) {
            dto.setLesMembresDEquipeIds(equipe.getLesMembresDEquipe().stream()
                    .map(Utilisateur::getId)
                    .collect(Collectors.toList()));
        }else{
            equipe.setLesMembresDEquipe(null);
        }

        if (equipe.getLesProjetsDEquipe() != null && !equipe.getLesProjetsDEquipe().isEmpty()) {
            dto.setLesProjetsDEquipeIds(equipe.getLesProjetsDEquipe().stream()
                    .map(Projet::getId)
                    .collect(Collectors.toList()));
        }else{
            equipe.setLesProjetsDEquipe(null);
        }

        return dto;
    }
}

