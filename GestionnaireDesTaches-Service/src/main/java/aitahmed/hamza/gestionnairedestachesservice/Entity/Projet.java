package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.StatutProjet;
import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Projet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String nom;

    private double budget;

    private String client, description;

    @Enumerated(EnumType.STRING)
    private StatutProjet statut;

    private Date dateDeCreation, dateDebut, dateFin;

    //============ Relation =============//

    @OneToMany(mappedBy = "projetDeTache")
    private Collection<Tache> tachesDeProjet;

    @ManyToOne
    private Utilisateur chefProjet;

    @ManyToOne
    private Equipe equipeDeProjet;

    @OneToMany(mappedBy = "competenceDeProjet")
    private Collection<CompetenceRequise> competenceRequise;
}
