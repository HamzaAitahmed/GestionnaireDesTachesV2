package aitahmed.hamza.gestionnairedestachesservice.RestController;

import aitahmed.hamza.gestionnairedestachesservice.Entity.CompetenceUtilisateur;
import aitahmed.hamza.gestionnairedestachesservice.Repository.CompetenceUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CompetenceUtilisateur")
public class CompetenceUtilisateurRest {
    @Autowired CompetenceUtilisateurRepository competenceUtilisateurRepository;

    @GetMapping(path="/All")
    public List<CompetenceUtilisateur> CompetenceUtilisateurs()
    {
        return competenceUtilisateurRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public CompetenceUtilisateur CompetenceUtilisateurId(@PathVariable int id)
    {
        return competenceUtilisateurRepository.findCompetenceUtilisateurById(id);
    }

    @PostMapping(path="/AjouterCompetenceUtilisateur")
    public CompetenceUtilisateur AjouterCompetenceUtilisateur(@RequestBody CompetenceUtilisateur competenceUtilisateur)
    {
        System.out.println("AjouterCompetenceUtilisateur : ");
        return competenceUtilisateurRepository.save(competenceUtilisateur);
    }

    @PutMapping(path="/ModifierCompetenceUtilisateur/{id}")
    public CompetenceUtilisateur ModifierCompetenceUtilisateur(@PathVariable int id, @RequestBody CompetenceUtilisateur competenceUtilisateur)
    {
        System.out.println("ModifierCompetenceUtilisateur id : "+id);
        return competenceUtilisateurRepository.findCompetenceUtilisateurById(id);
    }

    @DeleteMapping(path="/SupprimerCompetenceUtilisateur/{id}")
    public void supprimerCompetenceUtilisateur(@PathVariable int id)
    {
        System.out.println("DeleteCompetenceUtilisateursById :"+id);
        competenceUtilisateurRepository.deleteById(id);
    }
}
