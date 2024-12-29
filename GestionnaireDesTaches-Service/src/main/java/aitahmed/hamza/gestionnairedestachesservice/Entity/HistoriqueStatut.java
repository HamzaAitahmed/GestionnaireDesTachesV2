package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.StatutTache;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idTache;

    //============ Relation =============//

    @OneToMany(mappedBy = "historiqueStatutId")
    @JsonManagedReference
    private List<StatutAvecDate> historique = new ArrayList<>();;

//    @OneToOne
//    private Utilisateur modifiePar;

    @OneToOne @JsonBackReference
    private Tache lesStatutDeLaTache;

    //============ Les Methodes =============//

    public void setLesStatutDeLaTache(Tache lesStatutDeLaTache) {
        this.lesStatutDeLaTache = lesStatutDeLaTache;
        this.idTache = lesStatutDeLaTache.getId();
    }

    public void ajouterStatut(StatutTache statutTache) {
        StatutAvecDate statutAvecDate = new StatutAvecDate(statutTache, LocalDate.now());
        statutAvecDate.setHistoriqueStatutId(this);
        historique.add(statutAvecDate);
    }

    public String getStatut(LocalDate date) {
        for (StatutAvecDate statutAvecDate : historique) {
            if (statutAvecDate.dateDeModification.equals(date)) {
                return statutAvecDate.statut.toString();
            }
        }
        return null;
    }

}
