package aitahmed.hamza.gestionnairedestachesservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private LocalDate dateDeCreation;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    //============ Relation =============//

    @ManyToOne @JsonBackReference
    private Projet projetDeTache;

    @ManyToOne @JsonIgnore
    private Utilisateur assigneurDeTache;

    //============ Les Methodes =============//

}
