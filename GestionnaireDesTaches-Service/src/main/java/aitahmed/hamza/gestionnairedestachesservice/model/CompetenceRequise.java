package aitahmed.hamza.gestionnairedestachesservice.model;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Niveau;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class CompetenceRequise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true) // unique seulement dans le projet
    private String nom;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    //============ Relation =============//

    @ManyToMany(mappedBy = "CompetenceRequise")
    private Collection<Projet> CompetenceDesProjets;
}
