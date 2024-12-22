package aitahmed.hamza.gestionnairedestachesservice.RestController;

import aitahmed.hamza.gestionnairedestachesservice.Entity.Equipe;
import aitahmed.hamza.gestionnairedestachesservice.Repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Equipe")
public class EquipeRest {

    @Autowired private EquipeRepository equipeRepository;

    @GetMapping(path="/All")
    public List<Equipe> getMesEquipes() {
        return equipeRepository.findAll();
    }

    @GetMapping(path="/ById/{id}")
    public Equipe getEquipeById(@PathVariable int id) {
        return equipeRepository.findById(id);
    }

    @PostMapping(path="/AjouterEquipe")
    public Equipe AjouterEquipe(@RequestBody Equipe equipe)
    {
        System.out.println("AjouterEquipe : ");
//        System.out.println("AjouterEquipe : "+equipe.toString());
        return equipeRepository.save(equipe);
    }

    @PutMapping(path="/ModifierEquipe/{id}")
    public Equipe ModifierEquipe(@PathVariable int id, @RequestBody Equipe equipe)
    {
        System.out.println("ModifierEquipe id : "+id);
        return equipeRepository.findById(id);
    }

    @DeleteMapping(path="/SupprimerEquipe/{id}")
    public void supprimerEquipe(@PathVariable int id)
    {
        System.out.println("DeleteEquipesById :"+id);
        equipeRepository.deleteById(id);
    }

//    @DeleteMapping("/Delete/{id}")
//    public boolean supprimerEquipe(@PathVariable Integer id) {
//        equipeRepository.deleteById(id);
//        return true;
//    }

}
