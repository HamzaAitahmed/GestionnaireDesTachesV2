package aitahmed.hamza.gestionnairedestachesservice.services;

import aitahmed.hamza.gestionnairedestachesservice.entity.CompetenceRequise;
import aitahmed.hamza.gestionnairedestachesservice.repository.CompetenceRequiseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceRequiseService {

    private final CompetenceRequiseRepository competenceRequiseRepository;

    CompetenceRequiseService(CompetenceRequiseRepository competenceRequiseRepository){
        this.competenceRequiseRepository = competenceRequiseRepository;
    }
    public List<CompetenceRequise> getToutesLesCompetenceRequises(){
        return competenceRequiseRepository.findAll();
    }

    public CompetenceRequise getCompetenceRequiseById(int id){
        return competenceRequiseRepository.findCompetenceRequiseById(id);
    }

    public CompetenceRequise creerCompetenceRequise(CompetenceRequise competenceRequise){
        CompetenceRequise newCompetenceRequise = enregistrerCompetenceRequise(competenceRequise);
        competenceRequiseRepository.flush();
        return newCompetenceRequise;
    }

    public CompetenceRequise creerCompetenceRequiseVide(){
        CompetenceRequise newCompetenceRequise = enregistrerCompetenceRequise(new CompetenceRequise());
        competenceRequiseRepository.flush();
        return newCompetenceRequise;
    }

    public CompetenceRequise enregistrerCompetenceRequise(CompetenceRequise savedCompetenceRequise)
    {
        return competenceRequiseRepository.save(savedCompetenceRequise);
    }

    public CompetenceRequise ajouterCompetenceRequise(CompetenceRequise competenceRequiseAjouter) {
        return creerCompetenceRequise(competenceRequiseAjouter);
    }

    public CompetenceRequise modifierCompetenceRequise(int competenceRequiseId, CompetenceRequise nouvelleModificationCompetenceRequise)
    {
        CompetenceRequise competenceRequiseModifier = getCompetenceRequiseById(competenceRequiseId);
        copierDepuis(nouvelleModificationCompetenceRequise, competenceRequiseModifier);
        return enregistrerCompetenceRequise(competenceRequiseModifier);
    }

    public boolean supprimerCompetenceRequise(int competenceRequiseId)
    {
        competenceRequiseRepository.deleteById(competenceRequiseId);
        return true;
    }

    public void copierDepuis(CompetenceRequise source, CompetenceRequise target) {
        if (source.getNom() != null) target.setNom(source.getNom());
        if (source.getNiveau() != null) target.setNiveau(source.getNiveau());

        //============ Relation =============//

        target.setCompetence(source.getCompetence());
        if (source.getListCompetencesRequise() != null)target.setListCompetencesRequise(source.getListCompetencesRequise());

    }

}
