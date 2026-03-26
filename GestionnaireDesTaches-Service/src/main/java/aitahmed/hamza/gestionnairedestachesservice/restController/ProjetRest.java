package aitahmed.hamza.gestionnairedestachesservice.restController;

import aitahmed.hamza.gestionnairedestachesservice.constants.Constants;
import aitahmed.hamza.gestionnairedestachesservice.entity.Projet;
import aitahmed.hamza.gestionnairedestachesservice.services.ProjetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Projet")
public class ProjetRest {
    private final ProjetService projetService;

    ProjetRest(ProjetService projetService) {
        this.projetService = projetService;
    }

    @GetMapping(path="/{userId}/projets")
    public List<Projet> projets(@RequestParam(name = Constants.SEARCH , defaultValue = Constants.ALL_PROJECTS) String search , @PathVariable int userId )
    {
        System.out.println("search : "+search+" userId : "+userId );
        return switch (search) {
            case Constants.MY_PROJECT -> projetService.getProjetsByChefProjetId(userId);
            case Constants.OTHER_PROJECTS -> projetService.getOtherProjectByUserId(userId);
            case Constants.ALL_PROJECTS -> projetService.getAllProjectByUserId(userId);
            default -> projetService.getAllProjectByUserId(userId);
        };
    }

    @GetMapping(path="/All")
    public List<Projet> allProjets(@PathVariable int userId)
    {
        return projetService.getAllProjectByUserId(userId);
    }

    @GetMapping(path="/{id}")
    public Projet ProjetId(@PathVariable int id)
    {
        return projetService.getProjetById(id);
    }

    @PostMapping(path="/AjouterProjet")
    public Projet AjouterProjet(@RequestBody Projet projet)
    {
        System.out.println("AjouterProjet projet : ");
        System.out.println(projet);
        return projetService.ajouterProjet(projet);
    }

    @PutMapping(path="/ModifierProjet/{id}")
    public Projet ModifierProjet(@PathVariable int id, @RequestBody Projet projet)
    {
        System.out.println("ModifierProjet id : "+id);
        return projetService.modifierProjet(id, projet);
    }

    @DeleteMapping(path="/SupprimerProjet/{id}")
    public void supprimerProjet(@PathVariable int id)
    {
        System.out.println("DeleteProjetsById :"+id);
        projetService.supprimerProjet(id);
    }

}
