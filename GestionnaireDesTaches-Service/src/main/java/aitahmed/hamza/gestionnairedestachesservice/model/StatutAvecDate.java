package aitahmed.hamza.gestionnairedestachesservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class StatutAvecDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    String statut;
    LocalDateTime dateDeModification;

    public StatutAvecDate(String statut, LocalDateTime dateDeModification) {
        this.statut = statut;
        this.dateDeModification = dateDeModification;
    }

    //============ Les Relations =============//

    @ManyToOne
    private HistoriqueStatut HistoriqueStatutId;

    //============ Les Methodes =============//


}
