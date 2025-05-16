package aitahmed.hamza.gestionnairedestachesservice.restController;

import aitahmed.hamza.gestionnairedestachesservice.dtos.request.EquipeRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.EquipeResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.entity.Equipe;
import aitahmed.hamza.gestionnairedestachesservice.mappers.EquipeMapper;
import aitahmed.hamza.gestionnairedestachesservice.repository.EquipeRepository;
import aitahmed.hamza.gestionnairedestachesservice.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Equipe/{userId}")
public class EquipeRest {

    private final EquipeService equipeService;
    private final EquipeMapper equipeMapper;

    EquipeRest (EquipeService equipeService, EquipeMapper equipeMapper) {
        this.equipeService = equipeService;
        this.equipeMapper = equipeMapper;
    }

    @GetMapping(path="/All")
    public List<EquipeResponseDTO> getMesEquipes() {
        List<Equipe> equipes = equipeService.getToutesLesEquipes();
        return equipes.stream()
                .map(equipeMapper::EquipeToEquipeResponseDTO) // Utilisez le mapper pour convertir chaque equipe
                .collect(Collectors.toList());
    }

    @GetMapping(path="/{id}")
    public EquipeResponseDTO getEquipeById(@PathVariable int id) {
        Equipe equipe = equipeService.getEquipeById(id);
        return equipeMapper.EquipeToEquipeResponseDTO(equipe);
    }

    @PostMapping(path="/AjouterEquipe")
    public EquipeResponseDTO AjouterEquipe(@RequestBody EquipeRequestDTO equipeObjet)
    {
        Equipe recupererEquipe = equipeMapper.EquipeRequestDTOtoEquipe(equipeObjet);
        Equipe equipe = equipeService.ajouterEquipe(recupererEquipe);
        return equipeMapper.EquipeToEquipeResponseDTO(equipe);
    }

    @PutMapping(path="/ModifierEquipe/{id}")
    public EquipeResponseDTO ModifierEquipe(@PathVariable int id, @RequestBody EquipeRequestDTO equipeObjet)
    {
        Equipe recupererEquipe = equipeMapper.EquipeRequestDTOtoEquipe(equipeObjet);
        Equipe equipe = equipeService.modifierEquipe(id, recupererEquipe);
        return equipeMapper.EquipeToEquipeResponseDTO(equipe);
    }

    @DeleteMapping(path="/SupprimerEquipe/{id}")
    public void supprimerEquipe(@PathVariable int id)
    {
        equipeService.supprimerEquipe(id);
    }

//    @DeleteMapping("/Delete/{id}")
//    public boolean supprimerEquipe(@PathVariable Integer id) {
//        equipeService.deleteById(id);
//        return true;
//    }

}
