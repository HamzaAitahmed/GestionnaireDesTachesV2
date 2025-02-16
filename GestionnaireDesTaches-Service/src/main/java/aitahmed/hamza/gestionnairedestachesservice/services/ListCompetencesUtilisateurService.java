package aitahmed.hamza.gestionnairedestachesservice.services;

import aitahmed.hamza.gestionnairedestachesservice.entity.ListCompetencesUtilisateur;
import aitahmed.hamza.gestionnairedestachesservice.repository.ListCompetencesUtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCompetencesUtilisateurService {

    private final ListCompetencesUtilisateurRepository listCompetencesUtilisateurRepository;

    ListCompetencesUtilisateurService(ListCompetencesUtilisateurRepository listCompetencesUtilisateurRepository){
        this.listCompetencesUtilisateurRepository = listCompetencesUtilisateurRepository;
    }
    public List<ListCompetencesUtilisateur> getToutesLesListCompetencesUtilisateurs(){
        return listCompetencesUtilisateurRepository.findAll();
    }

    public ListCompetencesUtilisateur getListCompetencesUtilisateurById(int id){
        return listCompetencesUtilisateurRepository.findListCompetencesUtilisateurById(id);
    }

    public ListCompetencesUtilisateur creerListCompetencesUtilisateur(ListCompetencesUtilisateur listCompetencesUtilisateur){
        ListCompetencesUtilisateur newListCompetencesUtilisateur = enregistrerListCompetencesUtilisateur(listCompetencesUtilisateur);
        listCompetencesUtilisateurRepository.flush();
        return newListCompetencesUtilisateur;
    }

    public ListCompetencesUtilisateur creerListCompetencesUtilisateurVide(){
        ListCompetencesUtilisateur newListCompetencesUtilisateur = enregistrerListCompetencesUtilisateur(new ListCompetencesUtilisateur());
        listCompetencesUtilisateurRepository.flush();
        return newListCompetencesUtilisateur;
    }

    public ListCompetencesUtilisateur enregistrerListCompetencesUtilisateur(ListCompetencesUtilisateur savedListCompetencesUtilisateur)
    {
        return listCompetencesUtilisateurRepository.save(savedListCompetencesUtilisateur);
    }

    public ListCompetencesUtilisateur ajouterListCompetencesUtilisateur(ListCompetencesUtilisateur listCompetencesUtilisateurAjouter) {
        return creerListCompetencesUtilisateur(listCompetencesUtilisateurAjouter);
    }

    public ListCompetencesUtilisateur modifierListCompetencesUtilisateur(int listCompetencesUtilisateurId, ListCompetencesUtilisateur nouvelleModificationListCompetencesUtilisateur)
    {
        ListCompetencesUtilisateur listCompetencesUtilisateurModifier = getListCompetencesUtilisateurById(listCompetencesUtilisateurId);
        copierDepuis(nouvelleModificationListCompetencesUtilisateur, listCompetencesUtilisateurModifier);
        return enregistrerListCompetencesUtilisateur(listCompetencesUtilisateurModifier);
    }

    public boolean supprimerListCompetencesUtilisateur(int listCompetencesUtilisateurId)
    {
        listCompetencesUtilisateurRepository.deleteById(listCompetencesUtilisateurId);
        return true;
    }

    public void copierDepuis(ListCompetencesUtilisateur source, ListCompetencesUtilisateur target) {

        //============ Relation =============//

        if (source.getUtilisateur() != null )target.setUtilisateur(source.getUtilisateur());
        if (source.getLesCompetencesUtilisateur() != null)target.setLesCompetencesUtilisateur(source.getLesCompetencesUtilisateur());

    }

}
