package aitahmed.hamza.gestionnairedestachesservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class HistoriqueStatut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idTache;

    //============ Relation =============//

    @OneToMany(mappedBy = "historiqueStatutId")
    private List<StatutAvecDate> historique;

//    @OneToOne
//    private Utilisateur modifiePar;

    @OneToOne
    private Tache lesStatutDeLaTache;

    //============ Les Methodes =============//

    public void setLesStatutDeLaTache(Tache lesStatutDeLaTache) {
        this.lesStatutDeLaTache = lesStatutDeLaTache;
        this.idTache = lesStatutDeLaTache.getId();
    }

    public void ajouterStatut(String statut, LocalDate date) {
        historique.add(new StatutAvecDate(statut, date));
    }

    public String getStatut(LocalDate date) {
        for (StatutAvecDate statutAvecDate : historique) {
            if (statutAvecDate.dateDeModification.equals(date)) {
                return statutAvecDate.statut;
            }
        }
        return null;
    }
}
