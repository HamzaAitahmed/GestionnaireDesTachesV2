package aitahmed.hamza.gestionnairedestachesservice.RestController;

import aitahmed.hamza.gestionnairedestachesservice.Entity.Tache;
import aitahmed.hamza.gestionnairedestachesservice.Repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Tache")
public class TacheRest {
    @Autowired TacheRepository tacheRepository;

    @GetMapping(path="/All")
    public List<Tache> Taches()
    {
        return tacheRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public Tache TacheId(@PathVariable int id)
    {
        return tacheRepository.findById(id);
    }

    @PostMapping(path="/AjouterTache")
    public Tache AjouterTache(@RequestBody Tache tache)
    {
        System.out.println("AjouterTache : ");
//        System.out.println("AjouterTache : "+tache.toString());
        return tacheRepository.save(tache);
    }

    @PutMapping(path="/ModifierTache/{id}")
    public Tache ModifierTache(@PathVariable int id, @RequestBody Tache tache)
    {
        System.out.println("ModifierTache id : "+id);
        return tacheRepository.findById(id);
    }

    @DeleteMapping(path="/SupprimerTache/{id}")
    public void supprimerTache(@PathVariable int id)
    {
        System.out.println("DeleteTachesById :"+id);
        tacheRepository.deleteById(id);
    }
}
