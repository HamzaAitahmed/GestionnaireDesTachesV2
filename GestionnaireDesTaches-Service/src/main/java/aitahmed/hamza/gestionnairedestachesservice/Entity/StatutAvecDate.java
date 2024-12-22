package aitahmed.hamza.gestionnairedestachesservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class StatutAvecDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String statut;
    LocalDateTime dateDeModification;

    //============ Les Relations =============//

    @ManyToOne
    private HistoriqueStatut historiqueStatutId;

    //============ Les Methodes =============//

    public StatutAvecDate(String statut, LocalDateTime dateDeModification) {
        this.statut = statut;
        this.dateDeModification = dateDeModification;
    }

}
