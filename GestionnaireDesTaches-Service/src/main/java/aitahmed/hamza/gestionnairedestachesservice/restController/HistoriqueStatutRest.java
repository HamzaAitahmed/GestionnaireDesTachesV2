package aitahmed.hamza.gestionnairedestachesservice.restController;

import aitahmed.hamza.gestionnairedestachesservice.entity.HistoriqueStatut;
import aitahmed.hamza.gestionnairedestachesservice.repository.HistoriqueStatutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/HistoriqueStatut/{userId}")
public class HistoriqueStatutRest {
    @Autowired
    HistoriqueStatutRepository historiqueStatutRepository;

    @GetMapping(path="/All")
    public List<HistoriqueStatut> HistoriqueStatuts()
    {
        return historiqueStatutRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public HistoriqueStatut HistoriqueStatutId(@PathVariable int id)
    {
        return historiqueStatutRepository.findHistoriqueStatutById(id);
    }

    @PostMapping(path="/AjouterHistoriqueStatut")
    public HistoriqueStatut AjouterHistoriqueStatut(@RequestBody HistoriqueStatut historiqueStatut )
    {
        System.out.println("AjouterHistoriqueStatut : ");
        return historiqueStatutRepository.save(historiqueStatut);
    }

    @PutMapping(path="/ModifierHistoriqueStatut/{id}")
    public HistoriqueStatut ModifierHistoriqueStatut(@PathVariable int id, @RequestBody HistoriqueStatut historiqueStatut)
    {
        System.out.println("ModifierHistoriqueStatut id : "+id);
        return historiqueStatutRepository.findHistoriqueStatutById(id);
    }

    @DeleteMapping(path="/SupprimerHistoriqueStatut/{id}")
    public void supprimerHistoriqueStatut(@PathVariable int id)
    {
        System.out.println("DeleteHistoriqueStatutsById :"+id);
        historiqueStatutRepository.deleteById(id);
    }
}
