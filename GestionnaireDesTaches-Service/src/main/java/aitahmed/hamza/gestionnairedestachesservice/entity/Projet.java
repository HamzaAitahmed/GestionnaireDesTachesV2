package aitahmed.hamza.gestionnairedestachesservice.entity;

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

    private LocalDate dateDeCreation;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    //============ Relation =============//

    @OneToMany(mappedBy = "projetDeTache")
    @JsonManagedReference
    private Collection<Tache> lesTachesDeProjet;

    @ManyToOne  @JsonIgnore
    private Utilisateur chefProjet;

    @ManyToOne  @JsonIgnore
    private Equipe equipeDuProjet;

    //============ Les Methodes =============//


}
