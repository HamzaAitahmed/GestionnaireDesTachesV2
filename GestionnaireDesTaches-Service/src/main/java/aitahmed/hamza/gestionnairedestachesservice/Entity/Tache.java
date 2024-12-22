package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Priorite;
import aitahmed.hamza.gestionnairedestachesservice.Enum.StatutTache;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true) // unique seulement dans le projet
    private String nom;

    @Enumerated(EnumType.STRING)
    private StatutTache statutTache;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    private Date dateDeCreation, dateDebut, dateFin;

    private String description;

    //============ Relation =============//

    @ManyToOne
    private HistoriqueStatut historiqueStatut;

    @ManyToOne
    private Projet projetDeTache;

    @ManyToOne
    private Utilisateur assigneurDeTache;
}
