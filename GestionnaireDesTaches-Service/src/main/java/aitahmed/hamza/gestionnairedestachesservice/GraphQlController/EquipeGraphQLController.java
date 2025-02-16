package aitahmed.hamza.gestionnairedestachesservice.graphqlController;

import aitahmed.hamza.gestionnairedestachesservice.dtos.request.EquipeRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.EquipeResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.entity.Equipe;
import aitahmed.hamza.gestionnairedestachesservice.mappers.EquipeMapper;
import aitahmed.hamza.gestionnairedestachesservice.services.EquipeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EquipeGraphQLController {
    private final EquipeService equipeService;
    private final EquipeMapper equipeMapper;

    EquipeGraphQLController (EquipeService equipeService, EquipeMapper equipeMapper) {
        this.equipeService = equipeService;
        this.equipeMapper = equipeMapper;
    }

    @QueryMapping
    public List<EquipeResponseDTO> Equipes() {
        List<Equipe> equipes = equipeService.getToutesLesEquipes();
        return equipes.stream()
                .map(equipeMapper::EquipeToEquipeResponseDTO) // Utilisez le mapper pour convertir chaque equipe
                .collect(Collectors.toList());
    }

    @QueryMapping
    public EquipeResponseDTO EquipeById(@Argument int id) {
        Equipe equipe = equipeService.getEquipeById(id);
        return equipeMapper.EquipeToEquipeResponseDTO(equipe);
    }

    @MutationMapping
    public EquipeResponseDTO AjouterEquipe(@Argument EquipeRequestDTO equipeRequest)
    {
        Equipe recupererEquipe = equipeMapper.EquipeRequestDTOtoEquipe(equipeRequest);
        Equipe equipe = equipeService.ajouterEquipe(recupererEquipe);
        return equipeMapper.EquipeToEquipeResponseDTO(equipe);
    }

    @MutationMapping
    public EquipeResponseDTO ModifierEquipe(@Argument int id, @Argument EquipeRequestDTO equipeRequest)
    {
        Equipe recupererEquipe = equipeMapper.EquipeRequestDTOtoEquipe(equipeRequest);
        Equipe equipe = equipeService.modifierEquipe(id, recupererEquipe);
        return equipeMapper.EquipeToEquipeResponseDTO(equipe);
    }

    @MutationMapping
    public boolean supprimerEquipe(@Argument int id)
    {
        return equipeService.supprimerEquipe(id);
    }
    
}
