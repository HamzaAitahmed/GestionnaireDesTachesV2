package aitahmed.hamza.gestionnairedestachesservice.entity;

import aitahmed.hamza.gestionnairedestachesservice.enumeration.StatutTache;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class HistoriqueStatut {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //============ Relation =============//

//    @OneToOne
//    private Utilisateur modifiePar;

    @OneToOne @JsonBackReference
    private Tache tacheDeHistorique;

    @OneToMany(mappedBy = "historique")
    @JsonManagedReference
    private List<StatutAvecDate> listDesStatuts;

    //============ Les Methodes =============//

    public void ajouterStatut(StatutTache statutTache) {
        StatutAvecDate statutAvecDate = new StatutAvecDate(statutTache, LocalDate.now());
        statutAvecDate.setHistorique(this);
        listDesStatuts.add(statutAvecDate);
    }

    public String getStatut(LocalDate date) {
        for (StatutAvecDate statutAvecDate : listDesStatuts) {
            if (statutAvecDate.dateDeModification.equals(date)) {
                return statutAvecDate.statut.toString();
            }
        }
        return null;
    }

}
