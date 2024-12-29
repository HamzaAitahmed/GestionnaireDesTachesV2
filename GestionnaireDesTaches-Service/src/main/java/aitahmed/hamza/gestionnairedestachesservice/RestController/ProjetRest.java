package aitahmed.hamza.gestionnairedestachesservice.RestController;

import aitahmed.hamza.gestionnairedestachesservice.Entity.Projet;
import aitahmed.hamza.gestionnairedestachesservice.Repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Projet")
public class ProjetRest {
    @Autowired
    ProjetRepository projetRepository;

    @GetMapping(path="/All")
    public List<Projet> Projets()
    {
        return projetRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public Projet ProjetId(@PathVariable int id)
    {
        return projetRepository.findById(id);
    }

    @PostMapping(path="/AjouterProjet")
    public Projet AjouterProjet(@RequestBody Projet projet)
    {
        System.out.println("AjouterProjet : ");
        return projetRepository.save(projet);
    }

    @PutMapping(path="/ModifierProjet/{id}")
    public Projet ModifierProjet(@PathVariable int id, @RequestBody Projet projet)
    {
        System.out.println("ModifierProjet id : "+id);
        return projetRepository.findById(id);
    }

    @DeleteMapping(path="/SupprimerProjet/{id}")
    public void supprimerProjet(@PathVariable int id)
    {
        System.out.println("DeleteProjetsById :"+id);
        projetRepository.deleteById(id);
    }

}
