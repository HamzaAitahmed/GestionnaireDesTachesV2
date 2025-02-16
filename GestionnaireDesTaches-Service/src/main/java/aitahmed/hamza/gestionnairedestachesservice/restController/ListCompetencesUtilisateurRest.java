package aitahmed.hamza.gestionnairedestachesservice.restController;

import aitahmed.hamza.gestionnairedestachesservice.entity.ListCompetencesUtilisateur;
import aitahmed.hamza.gestionnairedestachesservice.repository.ListCompetencesUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ListCompetencesUtilisateur/{userId}")
public class ListCompetencesUtilisateurRest {
    @Autowired ListCompetencesUtilisateurRepository listCompetencesUtilisateurRepository;

    @GetMapping(path="/All")
    public List<ListCompetencesUtilisateur> Taches()
    {
        return listCompetencesUtilisateurRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public ListCompetencesUtilisateur ListCompetencesUtilisateurId(@PathVariable int id)
    {
        return listCompetencesUtilisateurRepository.findListCompetencesUtilisateurById(id);
    }

    @PostMapping(path="/AjouterListCompetencesUtilisateur")
    public ListCompetencesUtilisateur AjouterListCompetencesUtilisateur(@RequestBody ListCompetencesUtilisateur listCompetencesUtilisateur)
    {
        System.out.println("AjouterListCompetencesUtilisateur : ");
        return listCompetencesUtilisateurRepository.save(listCompetencesUtilisateur);
    }

    @PutMapping(path="/ModifierListCompetencesUtilisateur/{id}")
    public ListCompetencesUtilisateur ModifierListCompetencesUtilisateur(@PathVariable int id, @RequestBody ListCompetencesUtilisateur listCompetencesUtilisateur)
    {
        System.out.println("ModifierListCompetencesUtilisateur id : "+id);
        return listCompetencesUtilisateurRepository.findListCompetencesUtilisateurById(id);
    }

    @DeleteMapping(path="/SupprimerListCompetencesUtilisateur/{id}")
    public void supprimerListCompetencesUtilisateur(@PathVariable int id)
    {
        System.out.println("DeleteListCompetencesUtilisateursById :"+id);
        listCompetencesUtilisateurRepository.deleteById(id);
    }
}
