package aitahmed.hamza.gestionnairedestachesservice.model;

import aitahmed.hamza.gestionnairedestachesservice.Enum.StatutProjet;
import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Projet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(unique=true)
    private String Nom;

    private double Budget;

    private String Client, Description;

    @Enumerated(EnumType.STRING)
    private StatutProjet Statut;

    private Date dateDeCreation, dateDebut, dateFin;

    //============ Relation =============//

    @OneToMany(mappedBy = "ProjetDeTache")
    private Collection<Tache> TachesDeProjet;

    @ManyToOne
    private Utilisateur ChefProjet;

    @ManyToOne
    private Equipe EquipeDeProjet;

    @ManyToMany
    private Collection<CompetenceRequise> CompetenceRequise;
}
