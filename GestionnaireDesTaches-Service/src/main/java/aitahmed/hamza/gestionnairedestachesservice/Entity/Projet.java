package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.StatutProjet;
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

    private String client, description;

    @Enumerated(EnumType.STRING)
    private StatutProjet statut;

    private LocalDate dateDeCreation, dateDebut, dateFin;

    private Integer idChefProjet;

    private Integer  idEquipeDeProjet;

    private Integer idListCompetencesRequise;

    //============ Relation =============//

    @OneToOne
    private ListCompetencesRequise listMesCompetencesRequise;

    @OneToMany(mappedBy = "projetDeTache")
    private Collection<Tache> tachesDeProjet;

    @ManyToOne
    private Utilisateur chefProjet;

    @ManyToOne
    private Equipe equipeDeProjet;

    //============ Les Methodes =============//

    public void setChefProjet(Utilisateur chefProjet) {
        this.chefProjet = chefProjet;
        this.idChefProjet = chefProjet.getId();
    }

    public void setEquipeDeProjet(Equipe equipeDeProjet) {
        this.equipeDeProjet = equipeDeProjet;
        this.idEquipeDeProjet = equipeDeProjet.getId();
    }

}
