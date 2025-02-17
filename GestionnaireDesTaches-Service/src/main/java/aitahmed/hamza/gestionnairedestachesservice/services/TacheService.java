package aitahmed.hamza.gestionnairedestachesservice.services;


import aitahmed.hamza.gestionnairedestachesservice.entity.Tache;
import aitahmed.hamza.gestionnairedestachesservice.entity.Projet;
import aitahmed.hamza.gestionnairedestachesservice.entity.Tache;
import aitahmed.hamza.gestionnairedestachesservice.repository.TacheRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheService {

    private final TacheRepository tacheRepository;

    TacheService(TacheRepository tacheRepository){
        this.tacheRepository = tacheRepository;
    }

    public List<Tache> getToutesLesTaches(){
        return tacheRepository.findAll();
    }

    public List<Tache> getTachesByProjetId(int projetId){
        return tacheRepository.findTachesByProjetDeTacheId(projetId);
    }

    public List<Tache> getTachesByAssigneurId(int assigneurDeTacheId) {
        return tacheRepository.findTachesByAssigneurDeTacheId(assigneurDeTacheId);
    }

    public Tache getTacheById(int tacheId)
    {
        return tacheRepository.findTacheById(tacheId);
    }

    public Tache creerTache(Tache tache){
        Tache newTache = enregistrerTache(tache);
        tacheRepository.flush();
        return newTache;
    }

    public Tache creerTacheVide(){
        Tache newTache = enregistrerTache(new Tache());
        tacheRepository.flush();
        return newTache;
    }
    
    public Tache enregistrerTache(Tache savedTache)
    {
        return tacheRepository.save(savedTache);
    }

    public Tache ajouterTache(Tache tacheAjouter) {
        return  creerTache(tacheAjouter);
    }

    public Tache modifierTache(int tacheId, Tache nouvelleModificationTache)
    {
        Tache tacheModifier = getTacheById(tacheId);
        copierDepuis(nouvelleModificationTache, tacheModifier);
        return enregistrerTache(tacheModifier);
    }

    public boolean supprimerTache(int tacheId)
    {
        tacheRepository.deleteById(tacheId);
        return true;
    }

    public void copierDepuis(Tache source, Tache target) {
        if (source.getNom() != null) target.setNom(source.getNom());
        if (source.getDescription() != null) target.setDescription(source.getDescription());

        if (source.getStatutTache() != null) target.setStatutTache(source.getStatutTache());
        if (source.getPriorite() != null) target.setPriorite(source.getPriorite());

        if (source.getDateDeCreation() != null) target.setDateDeCreation(source.getDateDeCreation());
        if (source.getDateDebut() != null) target.setDateDebut(source.getDateDebut());
        if (source.getDateFin() != null) target.setDateFin(source.getDateFin());

        //============ Relation =============//

        if (source.getHistoriqueDeLaTache() != null) target.setHistoriqueDeLaTache(source.getHistoriqueDeLaTache());
        if (source.getProjetDeTache() != null) target.setProjetDeTache(source.getProjetDeTache());
        if (source.getAssigneurDeTache() != null) target.setAssigneurDeTache(source.getAssigneurDeTache());
    }



}


