package aitahmed.hamza.gestionnairedestachesservice.entity;

import aitahmed.hamza.gestionnairedestachesservice.enumeration.Priorite;
import aitahmed.hamza.gestionnairedestachesservice.enumeration.StatutTache;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Tache {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true) // unique seulement dans le projet
    private String nom;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatutTache statutTache;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    private LocalDate dateDeCreation;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    //============ Relation =============//

    @ManyToOne @JsonManagedReference
    private HistoriqueStatut historiqueDeLaTache;

    @ManyToOne @JsonBackReference
    private Projet projetDeTache;

    @ManyToOne @JsonIgnore
    private Utilisateur assigneurDeTache;

    //============ Les Methodes =============//

    public void setStatutTache(StatutTache statutTache) {
        this.statutTache = statutTache;
        this.historiqueDeLaTache.ajouterStatut(statutTache);
    }

}
