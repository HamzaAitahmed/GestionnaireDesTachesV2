package aitahmed.hamza.gestionnairedestachesservice.services;

import aitahmed.hamza.gestionnairedestachesservice.entity.Competence;
import aitahmed.hamza.gestionnairedestachesservice.repository.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService {

    private final CompetenceRepository competenceRepository;

    CompetenceService(CompetenceRepository competenceRepository){
        this.competenceRepository = competenceRepository;
    }
    public List<Competence> getToutesLesCompetences(){
        return competenceRepository.findAll();
    }

    public Competence getCompetenceById(int id){
        return competenceRepository.findCompetenceById(id);
    }

    public Competence creerCompetence(Competence competence){
        Competence newCompetence = enregistrerCompetence(competence);
        competenceRepository.flush();
        return newCompetence;
    }

    public Competence creerCompetenceVide(){
        Competence newCompetence = enregistrerCompetence(new Competence());
        competenceRepository.flush();
        return newCompetence;
    }

    public Competence enregistrerCompetence(Competence savedCompetence)
    {
        return competenceRepository.save(savedCompetence);
    }

    public Competence ajouterCompetence(Competence competenceAjouter) {
        return creerCompetence(competenceAjouter);
    }

    public Competence modifierCompetence(int competenceId, Competence nouvelleModificationCompetence)
    {
        Competence competenceModifier = getCompetenceById(competenceId);
        copierDepuis(nouvelleModificationCompetence, competenceModifier);
        return enregistrerCompetence(competenceModifier);
    }

    public boolean supprimerCompetence(int competenceId)
    {
        competenceRepository.deleteById(competenceId);
        return true;
    }

    public void copierDepuis(Competence source, Competence target) {
        if (source.getNom() != null) target.setNom(source.getNom());

        //============ Relation =============//

    }

}