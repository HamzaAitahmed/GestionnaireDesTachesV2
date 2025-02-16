package aitahmed.hamza.gestionnairedestachesservice.services;

import aitahmed.hamza.gestionnairedestachesservice.entity.StatutAvecDate;
import aitahmed.hamza.gestionnairedestachesservice.repository.StatutAvecDateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutAvecDateService {

    private final StatutAvecDateRepository statutAvecDateRepository;

    StatutAvecDateService(StatutAvecDateRepository statutAvecDateRepository){
        this.statutAvecDateRepository = statutAvecDateRepository;
    }

    public List<StatutAvecDate> getToutesLesStatutAvecDates(){
        return statutAvecDateRepository.findAll();
    }

    public StatutAvecDate creerStatutAvecDate()
    {
        StatutAvecDate nouveauStatutAvecDate = statutAvecDateRepository.save(new StatutAvecDate());
        statutAvecDateRepository.flush();
        return nouveauStatutAvecDate;
    }


    public StatutAvecDate getStatutAvecDateById(int statutAvecDateId)
    {
        return statutAvecDateRepository.findStatutAvecDateById(statutAvecDateId);
    }

    public StatutAvecDate creerStatutAvecDate(StatutAvecDate statutAvecDate){
        StatutAvecDate newStatutAvecDate = enregistrerStatutAvecDate(statutAvecDate);
        System.out.println( "Service creerStatutAvecDate : " + newStatutAvecDate );
        statutAvecDateRepository.flush();
        return newStatutAvecDate;
    }

    public StatutAvecDate creerStatutAvecDateVide(){
        StatutAvecDate newStatutAvecDate = enregistrerStatutAvecDate(new StatutAvecDate());
        statutAvecDateRepository.flush();
        return newStatutAvecDate;
    }

    public StatutAvecDate enregistrerStatutAvecDate(StatutAvecDate savedStatutAvecDate)
    {
        return statutAvecDateRepository.save(savedStatutAvecDate);
    }

    public StatutAvecDate ajouterStatutAvecDate(StatutAvecDate statutAvecDateAjouter) {
        System.out.println( "Service statutAvecDateAjouter : " + statutAvecDateAjouter );
        return creerStatutAvecDate(statutAvecDateAjouter);
    }

    public StatutAvecDate modifierStatutAvecDate(int statutAvecDateId, StatutAvecDate nouvelleModificationStatutAvecDate)
    {
        StatutAvecDate statutAvecDateModifier = getStatutAvecDateById(statutAvecDateId);
        copierDepuis(nouvelleModificationStatutAvecDate, statutAvecDateModifier);
        return enregistrerStatutAvecDate(statutAvecDateModifier);
    }

    public boolean supprimerStatutAvecDate(int statutAvecDateId)
    {
        statutAvecDateRepository.deleteById(statutAvecDateId);
        return true;
    }

    public void copierDepuis(StatutAvecDate source, StatutAvecDate target) {
        if (source.getStatut() != null) target.setStatut(source.getStatut());
        if (source.getDateDeModification() != null) target.setDateDeModification(source.getDateDeModification());

        //============ Relation =============//

        if (source.getHistorique() != null) target.setHistorique(source.getHistorique());
    }

}