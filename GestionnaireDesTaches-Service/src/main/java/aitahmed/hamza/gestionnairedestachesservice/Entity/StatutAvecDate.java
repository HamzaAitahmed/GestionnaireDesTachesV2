package aitahmed.hamza.gestionnairedestachesservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class StatutAvecDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    protected String statut;

    protected LocalDate dateDeModification;

    private Integer idHistoriqueStatut;

    //============ Les Relations =============//

    @ManyToOne
    private HistoriqueStatut historiqueStatutId;

    //============ Les Methodes =============//


    public void setHistoriqueStatutId(HistoriqueStatut historiqueStatutId) {
        this.historiqueStatutId = historiqueStatutId;
        this.idHistoriqueStatut = historiqueStatutId.getId();
    }

    public StatutAvecDate(String statut, LocalDate dateDeModification) {
        this.statut = statut;
        this.dateDeModification = dateDeModification;
    }

}
