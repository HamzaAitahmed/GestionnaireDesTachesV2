package aitahmed.hamza.gestionnairedestachesservice.RestController;

import aitahmed.hamza.gestionnairedestachesservice.Entity.ListCompetencesUtilisateur;
import aitahmed.hamza.gestionnairedestachesservice.Entity.Tache;
import aitahmed.hamza.gestionnairedestachesservice.Repository.ListCompetencesUtilisateurRepository;
import aitahmed.hamza.gestionnairedestachesservice.Repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ListCompetencesUtilisateur")
public class RestListCompetencesUtilisateur {
    @Autowired ListCompetencesUtilisateurRepository listCompetencesUtilisateurRepository;

    @GetMapping(path="/All")
    public List<ListCompetencesUtilisateur> Taches()
    {
        return listCompetencesUtilisateurRepository.findAll();
    }
}
