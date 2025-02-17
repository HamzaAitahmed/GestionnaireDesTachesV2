package aitahmed.hamza.gestionnairedestachesservice.services;


import aitahmed.hamza.gestionnairedestachesservice.entity.Equipe;
import aitahmed.hamza.gestionnairedestachesservice.repository.EquipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    private final EquipeRepository equipeRepository;

    EquipeService(EquipeRepository equipeRepository){
        this.equipeRepository = equipeRepository;
    }
    public List<Equipe> getToutesLesEquipes(){
        return equipeRepository.findAll();
    }

    public List<Equipe> getEquipeByChefEquipeId(int chefEquipeId) {
        return equipeRepository.findEquipesByChefEquipeId(chefEquipeId);
    }

    public List<Equipe> getEquipeByMembreEquipeId(int memberEquipeId) {
        return equipeRepository.findEquipesByLesMembresDEquipeId(memberEquipeId);
    }

    public List<Equipe> getEquipeByProjetId(int projetId) {
        return equipeRepository.findEquipesByLesProjetsDEquipeId(projetId);
    }

    public Equipe getEquipeById(int id){
        return equipeRepository.findEquipeById(id);
    }

    public Equipe creerEquipe(Equipe equipe){
        Equipe newEquipe = enregistrerEquipe(equipe);
        equipeRepository.flush();
        return newEquipe;
    }
    
    public Equipe creerEquipeVide(){
        Equipe newEquipe = enregistrerEquipe(new Equipe());
        equipeRepository.flush();
        return newEquipe;
    }

    public Equipe enregistrerEquipe(Equipe savedEquipe)
    {
        return equipeRepository.save(savedEquipe);
    }

    public Equipe ajouterEquipe(Equipe equipeAjouter) {
        return creerEquipe(equipeAjouter);
    }

    public Equipe modifierEquipe(int equipeId, Equipe nouvelleModificationEquipe)
    {
        Equipe equipeModifier = getEquipeById(equipeId);
        copierDepuis(nouvelleModificationEquipe, equipeModifier);
        return enregistrerEquipe(equipeModifier);
    }

    public boolean supprimerEquipe(int equipeId)
    {
        equipeRepository.deleteById(equipeId);
        return true;
    }

    public void copierDepuis(Equipe source, Equipe target) {
        if (source.getNom() != null) target.setNom(source.getNom());
        if (source.getDateDeCreation() != null) target.setDateDeCreation(source.getDateDeCreation());

        //============ Relation =============//

        if (source.getChefEquipe() != null )target.setChefEquipe(source.getChefEquipe());
        if (source.getLesMembresDEquipe() != null)target.setLesMembresDEquipe(source.getLesMembresDEquipe());
        if (source.getLesProjetsDEquipe() != null )target.setLesProjetsDEquipe(source.getLesProjetsDEquipe());
    }

}


