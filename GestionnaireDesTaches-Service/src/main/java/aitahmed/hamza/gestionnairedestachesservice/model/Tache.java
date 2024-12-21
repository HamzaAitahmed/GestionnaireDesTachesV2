package aitahmed.hamza.gestionnairedestachesservice.model;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Priorite;
import aitahmed.hamza.gestionnairedestachesservice.Enum.StatutTache;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(unique=true) // unique seulement dans le projet
    private String Nom;

    @Enumerated(EnumType.STRING)
    private StatutTache statutTache;

    @Enumerated(EnumType.STRING)
    private Priorite Priorite;

    private Date dateDeCreation, dateDebut, dateFin;

    private String Description;

    //============ Relation =============//

    @ManyToOne
    private HistoriqueStatut HistoriqueStatut;

    @ManyToOne
    private Projet ProjetDeTache;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private Utilisateur assignee;
}
