package aitahmed.hamza.gestionnairedestachesservice.mappers;

import aitahmed.hamza.gestionnairedestachesservice.dtos.request.InscriptionRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.request.UtilisateurRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.UtilisateurResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.entity.*;
import aitahmed.hamza.gestionnairedestachesservice.enumeration.Role;
import aitahmed.hamza.gestionnairedestachesservice.services.EquipeService;
import aitahmed.hamza.gestionnairedestachesservice.services.ListCompetencesUtilisateurService;
import aitahmed.hamza.gestionnairedestachesservice.services.ProjetService;
import aitahmed.hamza.gestionnairedestachesservice.services.TacheService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UtilisateurMapper {
    private final ListCompetencesUtilisateurService listCompetencesUtilisateurService;
    private final ProjetService projetService;
    private final TacheService tacheService;
    private final EquipeService equipeService;

    public UtilisateurMapper(ListCompetencesUtilisateurService listCompetencesUtilisateurService, ProjetService projetService, TacheService tacheService, EquipeService equipeService) {
        this.listCompetencesUtilisateurService = listCompetencesUtilisateurService;
        this.projetService = projetService;
        this.tacheService = tacheService;
        this.equipeService = equipeService;
    }

    public Utilisateur UtilisateurRequestDTOtoUtilisateur(UtilisateurRequestDTO dto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(null);
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setSalaire(dto.getSalaire());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setUsername(dto.getUsername());
        utilisateur.setGender(dto.getGender());
        utilisateur.setDateOfBirth(dto.getDateOfBirth());
        utilisateur.setDateInscription(dto.getDateInscription());
        utilisateur.setAnneeExperience(dto.getAnneeExperience());
        utilisateur.setProfilePicture(dto.getProfilePicture());
        utilisateur.setRole(Role.valueOf(dto.getRole()));

        if (dto.getListMesCompetencesId() != null) {
            ListCompetencesUtilisateur competences = listCompetencesUtilisateurService.getListCompetencesUtilisateurById(dto.getListMesCompetencesId());
            utilisateur.setListMesCompetences(competences);
        }

        if (dto.getMesProjetsIds() != null && !dto.getMesProjetsIds().isEmpty()) {
            List<Projet> projets = dto.getMesProjetsIds().stream()
                    .map(projetService::getProjetById)
                    .collect(Collectors.toList());
            utilisateur.setMesProjets(projets);
        }

        if (dto.getMesTachesIds() != null && !dto.getMesTachesIds().isEmpty()) {
            List<Tache> taches = dto.getMesTachesIds().stream()
                    .map(tacheService::getTacheById)
                    .collect(Collectors.toList());
            utilisateur.setMesTaches(taches);
        }

        if (dto.getMesEquipesIds() != null && !dto.getMesEquipesIds().isEmpty()) {
            List<Equipe> equipes = dto.getMesEquipesIds().stream()
                    .map(equipeService::getEquipeById)
                    .collect(Collectors.toList());
            utilisateur.setMesEquipes(equipes);
        }

        if (dto.getMembreDansLEquipeIds() != null && !dto.getMembreDansLEquipeIds().isEmpty()) {
            List<Equipe> membreEquipes = dto.getMembreDansLEquipeIds().stream()
                    .map(equipeService::getEquipeById)
                    .collect(Collectors.toList());
            utilisateur.setMembreDansLEquipe(membreEquipes);
        }

        return utilisateur;
    }

    public UtilisateurResponseDTO UtilisateurToUtilisateurResponseDTO(Utilisateur utilisateur) {
        UtilisateurResponseDTO dto = new UtilisateurResponseDTO();
        dto.setId(utilisateur.getId());
        dto.setEmail(utilisateur.getEmail());
        dto.setSalaire(utilisateur.getSalaire());
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setUsername(utilisateur.getUsername());
        dto.setGender(utilisateur.getGender());
        dto.setDateOfBirth(utilisateur.getDateOfBirth());
        dto.setDateInscription(utilisateur.getDateInscription());
        dto.setAnneeExperience(utilisateur.getAnneeExperience());
        dto.setProfilePicture(utilisateur.getProfilePicture());
        dto.setRole( (utilisateur.getRole()!=null) ? utilisateur.getRole().name() : "USER" );

        if (utilisateur.getListMesCompetences() != null ) {
            dto.setListMesCompetencesId(utilisateur.getListMesCompetences().getId());
        }

        if (utilisateur.getMesProjets() != null && !utilisateur.getMesProjets().isEmpty()) {
            dto.setMesProjetsIds(utilisateur.getMesProjets().stream()
                    .map(Projet::getId)
                    .collect(Collectors.toList()));
        }

        if (utilisateur.getMesTaches() != null && !utilisateur.getMesTaches().isEmpty()) {
            dto.setMesTachesIds(utilisateur.getMesTaches().stream()
                    .map(Tache::getId)
                    .collect(Collectors.toList()));
        }

        if (utilisateur.getMesEquipes() != null && !utilisateur.getMesEquipes().isEmpty()) {
            dto.setMesEquipesIds(utilisateur.getMesEquipes().stream()
                    .map(Equipe::getId)
                    .collect(Collectors.toList()));
        }

        if (utilisateur.getMembreDansLEquipe() != null && !utilisateur.getMembreDansLEquipe().isEmpty()) {
            dto.setMembreDansLEquipeIds(utilisateur.getMembreDansLEquipe().stream()
                    .map(Equipe::getId)
                    .collect(Collectors.toList()));
        }

        return dto;
    }


    public Utilisateur InscriptionRequestDTOtoUtilisateur(InscriptionRequestDTO dto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(dto.getUsername());
        utilisateur.setPassword(dto.getPassword());
        utilisateur.setEmail(dto.getEmail());
        return utilisateur;
    }

    public InscriptionRequestDTO UtilisateurtoInscriptionRequestDTO(Utilisateur utilisateur) {
        InscriptionRequestDTO dto = new InscriptionRequestDTO();
        dto.setUsername(utilisateur.getUsername());
        dto.setPassword(utilisateur.getPassword());
        dto.setEmail(utilisateur.getEmail());
        return dto;
    }

}
