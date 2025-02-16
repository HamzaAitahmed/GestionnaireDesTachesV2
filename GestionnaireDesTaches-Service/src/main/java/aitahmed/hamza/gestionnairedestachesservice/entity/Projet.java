package aitahmed.hamza.gestionnairedestachesservice.entity;

import aitahmed.hamza.gestionnairedestachesservice.enumeration.StatutProjet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;
import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Projet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String nom;

    private double budget;
    private String client;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatutProjet statut;

    private LocalDate dateDeCreation;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    //============ Relation =============//

    @OneToOne
    private ListCompetencesRequise listMesCompetences;

    @OneToMany(mappedBy = "projetDeTache")
    @JsonManagedReference
    private Collection<Tache> lesTachesDeProjet;

    @ManyToOne  @JsonIgnore
    private Utilisateur chefProjet;

    @ManyToOne  @JsonIgnore
    private Equipe equipeDuProjet;

    //============ Les Methodes =============//


}
