package aitahmed.hamza.gestionnairedestachesservice.services;

import aitahmed.hamza.gestionnairedestachesservice.entity.CompetenceUtilisateur;
import aitahmed.hamza.gestionnairedestachesservice.repository.CompetenceUtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceUtilisateurService {

    private final CompetenceUtilisateurRepository competenceUtilisateurRepository;

    CompetenceUtilisateurService(CompetenceUtilisateurRepository competenceUtilisateurRepository){
        this.competenceUtilisateurRepository = competenceUtilisateurRepository;
    }
    public List<CompetenceUtilisateur> getToutesLesCompetenceUtilisateurs(){
        return competenceUtilisateurRepository.findAll();
    }

    public CompetenceUtilisateur getCompetenceUtilisateurById(int id){
        return competenceUtilisateurRepository.findCompetenceUtilisateurById(id);
    }

    public CompetenceUtilisateur creerCompetenceUtilisateur(CompetenceUtilisateur competenceUtilisateur){
        CompetenceUtilisateur newCompetenceUtilisateur = enregistrerCompetenceUtilisateur(competenceUtilisateur);
        competenceUtilisateurRepository.flush();
        return newCompetenceUtilisateur;
    }

    public CompetenceUtilisateur creerCompetenceUtilisateurVide(){
        CompetenceUtilisateur newCompetenceUtilisateur = enregistrerCompetenceUtilisateur(new CompetenceUtilisateur());
        competenceUtilisateurRepository.flush();
        return newCompetenceUtilisateur;
    }

    public CompetenceUtilisateur enregistrerCompetenceUtilisateur(CompetenceUtilisateur savedCompetenceUtilisateur)
    {
        return competenceUtilisateurRepository.save(savedCompetenceUtilisateur);
    }

    public CompetenceUtilisateur ajouterCompetenceUtilisateur(CompetenceUtilisateur competenceUtilisateurAjouter) {
        return creerCompetenceUtilisateur(competenceUtilisateurAjouter);
    }

    public CompetenceUtilisateur modifierCompetenceUtilisateur(int competenceUtilisateurId, CompetenceUtilisateur nouvelleModificationCompetenceUtilisateur)
    {
        CompetenceUtilisateur competenceUtilisateurModifier = getCompetenceUtilisateurById(competenceUtilisateurId);
        copierDepuis(nouvelleModificationCompetenceUtilisateur, competenceUtilisateurModifier);
        return enregistrerCompetenceUtilisateur(competenceUtilisateurModifier);
    }

    public boolean supprimerCompetenceUtilisateur(int competenceUtilisateurId)
    {
        competenceUtilisateurRepository.deleteById(competenceUtilisateurId);
        return true;
    }

    public void copierDepuis(CompetenceUtilisateur source, CompetenceUtilisateur target) {
        if (source.getNom() != null) target.setNom(source.getNom());
        if (source.getNiveau() != null) target.setNiveau(source.getNiveau());

        //============ Relation =============//

        if (source.getCompetence() != null )target.setCompetence(source.getCompetence());
        if (source.getListCompetencesUtilisateur() != null)target.setListCompetencesUtilisateur(source.getListCompetencesUtilisateur());

    }

}
