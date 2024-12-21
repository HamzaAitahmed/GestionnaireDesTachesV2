package aitahmed.hamza.gestionnairedestachesservice.model;

import aitahmed.hamza.gestionnairedestachesservice.Enum.StatutTache;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class HistoriqueStatut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    //============ Relation =============//

    @OneToMany(mappedBy = "HistoriqueStatutId")
    private List<StatutAvecDate> historique;

    @OneToOne
    private Utilisateur modifiéPar;

    @OneToOne
    private Tache LesStatutDeLaTache;

    //============ Les Methodes =============//

    public void ajouterStatut(String statut, LocalDateTime date) {
        historique.add(new StatutAvecDate(statut, date));
    }

    public String getStatut(LocalDateTime date) {
        for (StatutAvecDate statutAvecDate : historique) {
            if (statutAvecDate.dateDeModification.equals(date)) {
                return statutAvecDate.statut;
            }
        }
        return null;
    }
}
