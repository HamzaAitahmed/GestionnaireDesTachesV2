//package aitahmed.hamza.gestionnairedestachesservice.GraphQlController;
//
//import aitahmed.hamza.gestionnairedestachesservice.Entity.Projet;
//import aitahmed.hamza.gestionnairedestachesservice.Repository.ProjetRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class ProjetGraphQLController {
//    @Autowired private ProjetRepository projetRepository;
//
//    @QueryMapping
//    public List<Projet> Projets()
//    {
//        return projetRepository.findAll();
//    }
//
//    @QueryMapping
//    public Projet ProjetId(@Argument int id)
//    {
//        return projetRepository.findById(id);
//    }
//
//    @MutationMapping
//    public Projet AjouterProjet(@Argument Projet projet)
//    {
//        System.out.println("AjouterProjet : ");
//        return projetRepository.save(projet);
//    }
//
//    @MutationMapping
//    public Projet ModifierProjet(@Argument int id, @Argument Projet projet)
//    {
//        System.out.println("ModifierProjet id : "+id);
//        return projetRepository.findById(id);
//    }
//
//    @MutationMapping
//    public boolean supprimerProjet(@Argument int id)
//    {
//        System.out.println("DeleteProjetsById :"+id);
//        projetRepository.deleteById(id);
//        return true;
//    }
//
//}
