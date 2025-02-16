package aitahmed.hamza.gestionnairedestachesservice.restController;

import aitahmed.hamza.gestionnairedestachesservice.entity.CompetenceRequise;
import aitahmed.hamza.gestionnairedestachesservice.repository.CompetenceRequiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CompetenceRequise/{userId}")
public class CompetenceRequiseRest {
    @Autowired CompetenceRequiseRepository competenceRequiseRepository;

    @GetMapping(path="/All")
    public List<CompetenceRequise> CompetenceRequises()
    {
        return competenceRequiseRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public CompetenceRequise CompetenceRequiseId(@PathVariable int id)
    {
        return competenceRequiseRepository.findCompetenceRequiseById(id);
    }

    @PostMapping(path="/AjouterCompetenceRequise")
    public CompetenceRequise AjouterCompetenceRequise(@RequestBody CompetenceRequise competenceRequise)
    {
        System.out.println("AjouterCompetenceRequise : ");
        return competenceRequiseRepository.save(competenceRequise);
    }

    @PutMapping(path="/ModifierCompetenceRequise/{id}")
    public CompetenceRequise ModifierCompetenceRequise(@PathVariable int id, @RequestBody CompetenceRequise competenceRequise)
    {
        System.out.println("ModifierCompetenceRequise id : "+id);
        return competenceRequiseRepository.findCompetenceRequiseById(id);
    }

    @DeleteMapping(path="/SupprimerCompetenceRequise/{id}")
    public void supprimerCompetenceRequise(@PathVariable int id)
    {
        System.out.println("DeleteCompetenceRequisesById :"+id);
        competenceRequiseRepository.deleteById(id);
    }
}
