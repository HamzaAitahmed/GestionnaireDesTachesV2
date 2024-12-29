package aitahmed.hamza.gestionnairedestachesservice.RestController;

import aitahmed.hamza.gestionnairedestachesservice.Entity.Competence;
import aitahmed.hamza.gestionnairedestachesservice.Repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Competence")
public class CompetenceRest {
    @Autowired
    CompetenceRepository competenceRepository;

    @GetMapping(path="/All")
    public List<Competence> Competences()
    {
        return competenceRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public Competence CompetenceId(@PathVariable int id)
    {
        return competenceRepository.findCompetenceById(id);
    }

    @PostMapping(path="/AjouterCompetence")
    public Competence AjouterCompetence(@RequestBody Competence competence )
    {
        System.out.println("AjouterCompetence : ");
        return competenceRepository.save(competence);
    }

    @PutMapping(path="/ModifierCompetence/{id}")
    public Competence ModifierCompetence(@PathVariable int id, @RequestBody Competence competence)
    {
        System.out.println("ModifierCompetence id : "+id);
        return competenceRepository.findCompetenceById(id);
    }

    @DeleteMapping(path="/SupprimerCompetence/{id}")
    public void supprimerCompetence(@PathVariable int id)
    {
        System.out.println("DeleteCompetencesById :"+id);
        competenceRepository.deleteById(id);
    }
}
