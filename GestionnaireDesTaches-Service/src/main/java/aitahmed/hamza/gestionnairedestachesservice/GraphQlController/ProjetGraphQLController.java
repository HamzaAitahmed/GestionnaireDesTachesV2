package aitahmed.hamza.gestionnairedestachesservice.graphqlController;

import aitahmed.hamza.gestionnairedestachesservice.dtos.request.ProjetRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.ProjetResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.entity.Projet;
import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.mappers.ProjetMapper;
import aitahmed.hamza.gestionnairedestachesservice.services.ProjetService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProjetGraphQLController {
    private final ProjetService projetService;
    private final ProjetMapper projetMapper;

    ProjetGraphQLController(ProjetService projetService,ProjetMapper projetMapper) {
        this.projetService = projetService;
        this.projetMapper = projetMapper;
    }

    public static final String MY_PROJECT = "Mes_Projets";
    public static final String OTHER_PROJECTS = "Les_Autres_Projets";
    public static final String ALL_PROJECTS = "Toutes_Les_Projets";

    public static final String SEARCH = "search";

    @QueryMapping
    public List<ProjetResponseDTO> Projets() {
        List<Projet> projets = projetService.getToutesLesProjets();

        return projets.stream()
                .map(projetMapper::ProjettoProjetResponseDTO) // Utilisez le mapper pour convertir chaque projet
                .collect(Collectors.toList());
    }

    @QueryMapping
    public List<ProjetResponseDTO> ProjetsSearch(@Argument(name = SEARCH ) String search , @Argument int id)
    {
        System.out.println("search = " + search);
        List<Projet> projets = switch (search) {
            case MY_PROJECT -> projetService.getProjetsByChefProjetId(id);
            case OTHER_PROJECTS -> projetService.getOtherProjectByUserId(id);
            default -> projetService.getAllProjectByUserId(id);
        };

        return projets.stream()
                .map(projetMapper::ProjettoProjetResponseDTO) // Utilisez le mapper pour convertir chaque projet
                .collect(Collectors.toList());
    }

    @QueryMapping
    public ProjetResponseDTO ProjetById(@Argument int id)
    {
        Projet projet = projetService.getProjetById(id);
        return projetMapper.ProjettoProjetResponseDTO(projet);
    }

    @MutationMapping
    public ProjetResponseDTO AjouterProjet(@Argument ProjetRequestDTO projetRequest)
    {
        Projet projet = projetMapper.ProjetRequestDTOtoProjet(projetRequest);
        projet = projetService.ajouterProjet(projet);
        return projetMapper.ProjettoProjetResponseDTO(projet);
    }

    @MutationMapping
    public ProjetResponseDTO ModifierProjet(@Argument int id, @Argument ProjetRequestDTO projetRequest)
    {
        Projet projet = projetMapper.ProjetRequestDTOtoProjet(projetRequest);
        projet = projetService.modifierProjet(id, projet);
        return projetMapper.ProjettoProjetResponseDTO(projet);
    }

    @MutationMapping
    public boolean supprimerProjet(@Argument int id)
    {
        return projetService.supprimerProjet(id);
    }

}
