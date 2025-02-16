package aitahmed.hamza.gestionnairedestachesservice.services;

import aitahmed.hamza.gestionnairedestachesservice.entity.ListCompetencesRequise;
import aitahmed.hamza.gestionnairedestachesservice.repository.ListCompetencesRequiseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCompetencesRequiseService {

    private final ListCompetencesRequiseRepository listCompetencesRequiseRepository;

    ListCompetencesRequiseService(ListCompetencesRequiseRepository listCompetencesRequiseRepository){
        this.listCompetencesRequiseRepository = listCompetencesRequiseRepository;
    }
    public List<ListCompetencesRequise> getToutesLesListCompetencesRequises(){
        return listCompetencesRequiseRepository.findAll();
    }

    public ListCompetencesRequise getListCompetencesRequiseById(int id){
        return listCompetencesRequiseRepository.findListCompetencesRequiseById(id);
    }

    public ListCompetencesRequise creerListCompetencesRequise(ListCompetencesRequise listCompetencesRequise){
        ListCompetencesRequise newListCompetencesRequise = enregistrerListCompetencesRequise(listCompetencesRequise);
        listCompetencesRequiseRepository.flush();
        return newListCompetencesRequise;
    }

    public ListCompetencesRequise creerListCompetencesRequiseVide(){
        ListCompetencesRequise newListCompetencesRequise = enregistrerListCompetencesRequise(new ListCompetencesRequise());
        listCompetencesRequiseRepository.flush();
        return newListCompetencesRequise;
    }

    public ListCompetencesRequise enregistrerListCompetencesRequise(ListCompetencesRequise savedListCompetencesRequise)
    {
        return listCompetencesRequiseRepository.save(savedListCompetencesRequise);
    }

    public ListCompetencesRequise ajouterListCompetencesRequise(ListCompetencesRequise listCompetencesRequiseAjouter) {
        return creerListCompetencesRequise(listCompetencesRequiseAjouter);
    }

    public ListCompetencesRequise modifierListCompetencesRequise(int listCompetencesRequiseId, ListCompetencesRequise nouvelleModificationListCompetencesRequise)
    {
        ListCompetencesRequise listCompetencesRequiseModifier = getListCompetencesRequiseById(listCompetencesRequiseId);
        copierDepuis(nouvelleModificationListCompetencesRequise, listCompetencesRequiseModifier);
        return enregistrerListCompetencesRequise(listCompetencesRequiseModifier);
    }

    public boolean supprimerListCompetencesRequise(int listCompetencesRequiseId)
    {
        listCompetencesRequiseRepository.deleteById(listCompetencesRequiseId);
        return true;
    }

    public void copierDepuis(ListCompetencesRequise source, ListCompetencesRequise target) {

        //============ Relation =============//

        if (source.getProjet() != null )target.setProjet(source.getProjet());
        if (source.getLesCompetencesRequise() != null)target.setLesCompetencesRequise(source.getLesCompetencesRequise());

    }

}
