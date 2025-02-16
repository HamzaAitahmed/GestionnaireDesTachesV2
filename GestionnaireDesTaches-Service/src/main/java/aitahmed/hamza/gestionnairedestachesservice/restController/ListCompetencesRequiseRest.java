package aitahmed.hamza.gestionnairedestachesservice.restController;

import aitahmed.hamza.gestionnairedestachesservice.entity.ListCompetencesRequise;
import aitahmed.hamza.gestionnairedestachesservice.repository.ListCompetencesRequiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ListCompetencesRequise/{userId}")
public class ListCompetencesRequiseRest {
    @Autowired ListCompetencesRequiseRepository listCompetencesRequiseRepository;

    @GetMapping(path="/All")
    public List<ListCompetencesRequise> Taches()
    {
        return listCompetencesRequiseRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public ListCompetencesRequise ListCompetencesRequiseId(@PathVariable int id)
    {
        return listCompetencesRequiseRepository.findListCompetencesRequiseById(id);
    }

    @PostMapping(path="/AjouterListCompetencesRequise")
    public ListCompetencesRequise AjouterListCompetencesRequise(@RequestBody ListCompetencesRequise listCompetencesRequise)
    {
        System.out.println("AjouterListCompetencesRequise : ");
        return listCompetencesRequiseRepository.save(listCompetencesRequise);
    }

    @PutMapping(path="/ModifierListCompetencesRequise/{id}")
    public ListCompetencesRequise ModifierListCompetencesRequise(@PathVariable int id, @RequestBody ListCompetencesRequise listCompetencesRequise)
    {
        System.out.println("ModifierListCompetencesRequise id : "+id);
        return listCompetencesRequiseRepository.findListCompetencesRequiseById(id);
    }

    @DeleteMapping(path="/SupprimerListCompetencesRequise/{id}")
    public void supprimerListCompetencesRequise(@PathVariable int id)
    {
        System.out.println("DeleteListCompetencesRequisesById :"+id);
        listCompetencesRequiseRepository.deleteById(id);
    }
}
