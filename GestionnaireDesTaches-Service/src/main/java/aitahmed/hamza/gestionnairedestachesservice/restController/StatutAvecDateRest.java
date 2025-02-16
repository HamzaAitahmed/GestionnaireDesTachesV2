package aitahmed.hamza.gestionnairedestachesservice.restController;

import aitahmed.hamza.gestionnairedestachesservice.entity.StatutAvecDate;
import aitahmed.hamza.gestionnairedestachesservice.repository.StatutAvecDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/StatutAvecDate/{userId}")
public class StatutAvecDateRest {
    @Autowired
    StatutAvecDateRepository statutAvecDateRepository;

    @GetMapping(path="/All")
    public List<StatutAvecDate> StatutAvecDates()
    {
        return statutAvecDateRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public StatutAvecDate StatutAvecDateId(@PathVariable int id)
    {
        return statutAvecDateRepository.findStatutAvecDateById(id);
    }

    @PostMapping(path="/AjouterStatutAvecDate")
    public StatutAvecDate AjouterStatutAvecDate(@RequestBody StatutAvecDate competence )
    {
        System.out.println("AjouterStatutAvecDate : ");
        return statutAvecDateRepository.save(competence);
    }

    @PutMapping(path="/ModifierStatutAvecDate/{id}")
    public StatutAvecDate ModifierStatutAvecDate(@PathVariable int id, @RequestBody StatutAvecDate competence)
    {
        System.out.println("ModifierStatutAvecDate id : "+id);
        return statutAvecDateRepository.findStatutAvecDateById(id);
    }

    @DeleteMapping(path="/SupprimerStatutAvecDate/{id}")
    public void supprimerStatutAvecDate(@PathVariable int id)
    {
        System.out.println("DeleteStatutAvecDatesById :"+id);
        statutAvecDateRepository.deleteById(id);
    }
}
