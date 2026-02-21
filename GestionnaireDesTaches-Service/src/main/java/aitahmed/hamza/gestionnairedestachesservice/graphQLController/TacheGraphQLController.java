package aitahmed.hamza.gestionnairedestachesservice.graphQLController;

import aitahmed.hamza.gestionnairedestachesservice.dtos.request.TacheRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.TacheResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.entity.Tache;
import aitahmed.hamza.gestionnairedestachesservice.mappers.TacheMapper;
import aitahmed.hamza.gestionnairedestachesservice.services.TacheService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TacheGraphQLController {
    private final TacheService tacheService;
    private final TacheMapper tacheMapper;

    TacheGraphQLController(TacheService tacheService, TacheMapper tacheMapper) {
        this.tacheService = tacheService;
        this.tacheMapper = tacheMapper;
    }

    @QueryMapping
    public List<TacheResponseDTO> Taches()
    {
        List<Tache> taches = tacheService.getToutesLesTaches();
        return taches.stream()
                .map(tacheMapper::TachetoTacheResponseDTO) // Utilisez le mapper pour convertir chaque tache
                .collect(Collectors.toList());
    }

    @QueryMapping
    public List<TacheResponseDTO> TachesByUtilisateurId(@Argument Integer utilisateurId )
    {
        List<Tache> taches = tacheService.getTachesByAssigneurId(utilisateurId);
        return taches.stream()
                .map(tacheMapper::TachetoTacheResponseDTO) // Utilisez le mapper pour convertir chaque tache
                .collect(Collectors.toList());
    }

    @QueryMapping
    public List<TacheResponseDTO> TachesByProjetId(@Argument Integer projetId)
    {
        List<Tache> taches = tacheService.getTachesByProjetId(projetId);
        return taches.stream()
                .map(tacheMapper::TachetoTacheResponseDTO) // Utilisez le mapper pour convertir chaque tache
                .collect(Collectors.toList());
    }

    @QueryMapping
    public TacheResponseDTO TacheById(@Argument Integer tacheId)
    {
        Tache tache = tacheService.getTacheById(tacheId);
        return tacheMapper.TachetoTacheResponseDTO(tache);
    }

    @MutationMapping
    public TacheResponseDTO AjouterTache(@Argument TacheRequestDTO tacheObjet)
    {
        Tache recupererTache = tacheMapper.TacheRequestDTOtoTache(tacheObjet);
        Tache tache = tacheService.ajouterTache(recupererTache);
        return tacheMapper.TachetoTacheResponseDTO(tache);
    }

    @MutationMapping
    public TacheResponseDTO ModifierTache(@Argument Integer id, @Argument TacheRequestDTO tacheObjet)
    {
        Tache recupererTache = tacheMapper.TacheRequestDTOtoTache(tacheObjet);
        Tache tache = tacheService.modifierTache(id, recupererTache);
        return tacheMapper.TachetoTacheResponseDTO(tache);
    }

    @MutationMapping
    public boolean supprimerTache(@Argument Integer id)
    {
        return tacheService.supprimerTache(id);
    }

}
