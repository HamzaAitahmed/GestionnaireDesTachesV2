package aitahmed.hamza.gestionnairedestachesservice.RestController;

import aitahmed.hamza.gestionnairedestachesservice.Entity.CompetenceUtilisateur;
import aitahmed.hamza.gestionnairedestachesservice.Repository.CompetenceUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/CompetenceUtilisateur")
public class RestCompetenceUtilisateur {
    @Autowired CompetenceUtilisateurRepository competenceUtilisateurRepository;

    @GetMapping(path="/All")
    public List<CompetenceUtilisateur> Taches()
    {
        return competenceUtilisateurRepository.findAll();
    }
}
