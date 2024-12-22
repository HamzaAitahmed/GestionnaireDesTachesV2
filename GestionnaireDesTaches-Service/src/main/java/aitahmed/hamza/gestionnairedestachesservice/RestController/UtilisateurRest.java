package aitahmed.hamza.gestionnairedestachesservice.RestController;

import aitahmed.hamza.gestionnairedestachesservice.Entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Utilisateur")
public class UtilisateurRest {
    @Autowired  UtilisateurRepository utilisateurRepository;

    @GetMapping(path="/All")
    public List<Utilisateur> Utilisateurs()
    {
        return utilisateurRepository.findAll();
    }

    @GetMapping(path="/ById/{id}")
    public Utilisateur UtilisateurId(@PathVariable int id)
    {
        return utilisateurRepository.findById(id);
    }

    @GetMapping(path="/ByEmail/{email}")
    public Utilisateur UtilisateurEmail(@PathVariable String email)
    {
        return utilisateurRepository.findByEmail(email);
    }

    @PostMapping(path="/AjouterUtilisateur")
    public Utilisateur AjouterUtilisateur(@RequestBody Utilisateur utilisateur)
    {
        System.out.println("AjouterUtilisateur : ");
//        System.out.println("AjouterUtilisateur : "+utilisateur.toString());
        return utilisateurRepository.save(utilisateur);
    }

    @PutMapping(path="/ModifierUtilisateur/{id}")
    public Utilisateur ModifierUtilisateur(@PathVariable int id, @RequestBody Utilisateur utilisateur)
    {
        System.out.println("ModifierUtilisateur id : "+id);
        return utilisateurRepository.findById(id);
    }

    @DeleteMapping(path="/SupprimerUtilisateur/{id}")
    public void supprimerUtilisateur(@PathVariable int id)
    {
        System.out.println("DeleteUtilisateursById :"+id);
        utilisateurRepository.deleteById(id);
    }

}
