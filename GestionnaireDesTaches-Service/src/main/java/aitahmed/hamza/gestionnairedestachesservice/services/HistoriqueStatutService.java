package aitahmed.hamza.gestionnairedestachesservice.services;

import aitahmed.hamza.gestionnairedestachesservice.entity.HistoriqueStatut;
import aitahmed.hamza.gestionnairedestachesservice.repository.HistoriqueStatutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueStatutService {

    private final HistoriqueStatutRepository historiqueStatutRepository;

    HistoriqueStatutService(HistoriqueStatutRepository historiqueStatutRepository){
        this.historiqueStatutRepository = historiqueStatutRepository;
    }
    public List<HistoriqueStatut> getToutesLesHistoriqueStatuts(){
        return historiqueStatutRepository.findAll();
    }

    public HistoriqueStatut getHistoriqueStatutById(int id){
        return historiqueStatutRepository.findHistoriqueStatutById(id);
    }

    public HistoriqueStatut creerHistoriqueStatut(HistoriqueStatut historiqueStatut){
        HistoriqueStatut newHistoriqueStatut = enregistrerHistoriqueStatut(historiqueStatut);
        historiqueStatutRepository.flush();
        return newHistoriqueStatut;
    }

    public HistoriqueStatut creerHistoriqueStatutVide(){
        HistoriqueStatut newHistoriqueStatut = enregistrerHistoriqueStatut(new HistoriqueStatut());
        historiqueStatutRepository.flush();
        return newHistoriqueStatut;
    }

    public HistoriqueStatut enregistrerHistoriqueStatut(HistoriqueStatut savedHistoriqueStatut)
    {
        return historiqueStatutRepository.save(savedHistoriqueStatut);
    }

    public HistoriqueStatut ajouterHistoriqueStatut(HistoriqueStatut historiqueStatutAjouter) {
        return creerHistoriqueStatut(historiqueStatutAjouter);
    }

    public HistoriqueStatut modifierHistoriqueStatut(int historiqueStatutId, HistoriqueStatut nouvelleModificationHistoriqueStatut)
    {
        HistoriqueStatut historiqueStatutModifier = getHistoriqueStatutById(historiqueStatutId);
        copierDepuis(nouvelleModificationHistoriqueStatut, historiqueStatutModifier);
        return enregistrerHistoriqueStatut(historiqueStatutModifier);
    }

    public boolean supprimerHistoriqueStatut(int historiqueStatutId)
    {
        historiqueStatutRepository.deleteById(historiqueStatutId);
        return true;
    }

    public void copierDepuis(HistoriqueStatut source, HistoriqueStatut target) {

        //============ Relation =============//

        if (source.getTacheDeHistorique() != null )target.setTacheDeHistorique(source.getTacheDeHistorique());
        if (source.getListDesStatuts() != null)target.setListDesStatuts(source.getListDesStatuts());

    }

}
