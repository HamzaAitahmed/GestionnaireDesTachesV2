package aitahmed.hamza.gestionnairedestachesservice.graphQLController;

import aitahmed.hamza.gestionnairedestachesservice.dtos.request.UtilisateurRequestDTO;
import aitahmed.hamza.gestionnairedestachesservice.dtos.response.UtilisateurResponseDTO;
import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.mappers.UtilisateurMapper;
import aitahmed.hamza.gestionnairedestachesservice.services.UtilisateurService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UtilisateurGraphQLController {
    private final UtilisateurService utilisateurService;
    private final UtilisateurMapper utilisateurMapper;


    UtilisateurGraphQLController (UtilisateurService utilisateurService,UtilisateurMapper utilisateurMapper) {
        this.utilisateurService = utilisateurService;
        this.utilisateurMapper = utilisateurMapper;
    }
    
    @QueryMapping
    public List<UtilisateurResponseDTO> Utilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.getToutesLesUtilisateurs();
        return utilisateurs.stream()
                .map(utilisateurMapper::UtilisateurToUtilisateurResponseDTO) // Utilisez le mapper pour convertir chaque utilisateur
                .collect(Collectors.toList());

    }

    @QueryMapping
    public UtilisateurResponseDTO UtilisateurById(@Argument int id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        return utilisateurMapper.UtilisateurToUtilisateurResponseDTO(utilisateur);
    }

    @QueryMapping
    public UtilisateurResponseDTO UtilisateurByEmail(@Argument String email) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurByEmail(email);
        return utilisateurMapper.UtilisateurToUtilisateurResponseDTO(utilisateur);
    }

    @MutationMapping
    public UtilisateurResponseDTO AjouterUtilisateur(@Argument UtilisateurRequestDTO utilisateurRequest)
    {
        Utilisateur recupererUtilisateur = utilisateurMapper.UtilisateurRequestDTOtoUtilisateur(utilisateurRequest);
        Utilisateur utilisateur = utilisateurService.ajouterUtilisateur(recupererUtilisateur);
        return utilisateurMapper.UtilisateurToUtilisateurResponseDTO(utilisateur);

    }

    @MutationMapping
    public UtilisateurResponseDTO ModifierUtilisateur(@Argument int id, @Argument UtilisateurRequestDTO utilisateurRequest)
    {
        Utilisateur recupererUtilisateur = utilisateurMapper.UtilisateurRequestDTOtoUtilisateur(utilisateurRequest);
        Utilisateur utilisateur = utilisateurService.modifierUtilisateur(id, recupererUtilisateur);
        return utilisateurMapper.UtilisateurToUtilisateurResponseDTO(utilisateur);

    }

    @MutationMapping
    public boolean supprimerUtilisateur(@Argument int id)
    {
        return utilisateurService.supprimerUtilisateur(id);
    }

    
}
