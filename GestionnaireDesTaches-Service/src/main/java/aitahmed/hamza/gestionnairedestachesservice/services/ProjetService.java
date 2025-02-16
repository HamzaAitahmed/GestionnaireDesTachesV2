package aitahmed.hamza.gestionnairedestachesservice.services;


import aitahmed.hamza.gestionnairedestachesservice.entity.Projet;
import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.repository.ProjetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService {

    private final ProjetRepository projetRepository;

    ProjetService(ProjetRepository projetRepository){
        this.projetRepository = projetRepository;
    }

    public List<Projet> getToutesLesProjets(){
        return projetRepository.findAll();
    }

    public List<Projet> getProjetsByChefProjetId(int userId){
        System.out.println("getProjetsByChefProjetId");
        return projetRepository.findProjetsByChefProjetId(userId);
    }

    public List<Projet> getOtherProjectByUserId(int userId){
        System.out.println("getOtherProjectByUserId");
        return projetRepository.findOtherProjectByUserId(userId);
    }

    public List<Projet> getAllProjectByUserId(int userId){
        System.out.println("ProjetService.getAllProjectByUserId(userId)");
        return projetRepository.findAllProjectByUserId(userId);
    }
    
    public Projet creerProjet()
    {
        Projet nouveauProjet = projetRepository.save(new Projet());
        projetRepository.flush();
        return nouveauProjet;
    }


    public Projet getProjetById(int projetId)
    {
        return projetRepository.findProjetById(projetId);
    }

    public Projet creerProjet(Projet projet){
        Projet newProjet = enregistrerProjet(projet);
        System.out.println( "Service creerProjet : " + newProjet );
        projetRepository.flush();
        return newProjet;
    }

    public Projet creerProjetVide(){
        Projet newProjet = enregistrerProjet(new Projet());
        projetRepository.flush();
        return newProjet;
    }

    public Projet enregistrerProjet(Projet savedProjet)
    {
        return projetRepository.save(savedProjet);
    }

    public Projet ajouterProjet(Projet projetAjouter) {
        System.out.println( "Service projetAjouter : " + projetAjouter );
        return creerProjet(projetAjouter);
    }

    public Projet modifierProjet(int projetId, Projet nouvelleModificationProjet)
    {
        Projet projetModifier = getProjetById(projetId);
        copierDepuis(nouvelleModificationProjet, projetModifier);
        return enregistrerProjet(projetModifier);
    }

    public boolean supprimerProjet(int projetId)
    {
        projetRepository.deleteById(projetId);
        return true;
    }

    public void copierDepuis(Projet source, Projet target) {
        if (source.getNom() != null) target.setNom(source.getNom());
        if (source.getBudget() < 0) target.setBudget(source.getBudget());
        if (source.getClient() != null) target.setClient(source.getClient());
        if (source.getDescription() != null) target.setDescription(source.getDescription());
        if (source.getStatut() != null) target.setStatut(source.getStatut());

        if (source.getDateDeCreation() != null) target.setDateDeCreation(source.getDateDeCreation());
        if (source.getDateDebut() != null) target.setDateDebut(source.getDateDebut());
        if (source.getDateFin() != null) target.setDateFin(source.getDateFin());

        //============ Relation =============//

        if (source.getListMesCompetences() != null) target.setListMesCompetences(source.getListMesCompetences());
        if (source.getLesTachesDeProjet() != null) target.setLesTachesDeProjet(source.getLesTachesDeProjet());
        if (source.getChefProjet() != null) target.setChefProjet(source.getChefProjet());
        if (source.getEquipeDuProjet() != null) target.setEquipeDuProjet(source.getEquipeDuProjet());
    }

}


