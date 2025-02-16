package aitahmed.hamza.gestionnairedestachesservice.entity;

import aitahmed.hamza.gestionnairedestachesservice.enumeration.StatutTache;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class StatutAvecDate {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    protected StatutTache statut;

    protected LocalDate dateDeModification;

    //============ Les Relations =============//

    @ManyToOne @JsonBackReference
    private HistoriqueStatut historique;

    //============ Les Methodes =============//

    public StatutAvecDate(StatutTache statut, LocalDate dateDeModification) {
        this.statut = statut;
        this.dateDeModification = dateDeModification;
    }

}
