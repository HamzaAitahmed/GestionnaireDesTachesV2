package aitahmed.hamza.gestionnairedestachesservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String nom;

    private LocalDate dateDeCreation;

    //============ Relation =============//

    @ManyToOne @JsonBackReference
    private Utilisateur chefEquipe;

    @ManyToMany @JsonManagedReference
    private  Collection<Utilisateur> lesMembresDEquipe;

    @JsonIgnore @OneToMany(mappedBy = "equipeDuProjet")
    private Collection<Projet> lesProjetsDEquipe;


    //============ Les Methodes =============//

}
