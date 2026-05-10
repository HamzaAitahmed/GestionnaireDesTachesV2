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

    @Column(unique=true)
    private String nom;
    private String description;
    private boolean statut=false;

    private LocalDate dateDeCreation;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @ManyToOne @JsonBackReference
    private Projet projetDeTache;

    @ManyToOne @JsonIgnore
    private Utilisateur assigneurDeTache;

}
