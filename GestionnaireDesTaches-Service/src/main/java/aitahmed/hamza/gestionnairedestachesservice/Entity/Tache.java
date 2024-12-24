package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Priorite;
import aitahmed.hamza.gestionnairedestachesservice.Enum.StatutTache;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true) // unique seulement dans le projet
    private String nom;

    @Enumerated(EnumType.STRING)
    private StatutTache statutTache;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    private LocalDate dateDeCreation;

    private LocalDate dateDebut, dateFin;

    private String description;

    private Integer idAssigneurDeTache;

    private Integer idProjetDeTache;

    private Integer idHistoriqueStatut;

    //============ Relation =============//

    @ManyToOne
    private HistoriqueStatut historiqueStatut;

    @ManyToOne
    private Projet projetDeTache;

    @ManyToOne
    private Utilisateur assigneurDeTache;

    //============ Les Methodes =============//

    public void setStatutTache(StatutTache statutTache) {
        System.out.println("Statut Change from " + this.statutTache + " to " + statutTache);
        this.statutTache = statutTache;
        this.historiqueStatut.ajouterStatut(statutTache.toString(), LocalDate.now());
        System.out.println("setStatutTache Without Lombok ....");
    }

    public void setHistoriqueStatut(HistoriqueStatut historiqueStatut) {
        this.historiqueStatut = historiqueStatut;
        this.idHistoriqueStatut = historiqueStatut.getId();
    }

    public void setProjetDeTache(Projet projetDeTache) {
        this.projetDeTache = projetDeTache;
        this.idProjetDeTache = projetDeTache.getId();
    }

    public void setAssigneurDeTache(Utilisateur assigneurDeTache) {
        System.out.println("Change Utilisateur " +  this.assigneurDeTache.getId() + " ==> " + assigneurDeTache.getId());
        this.assigneurDeTache = assigneurDeTache;
        this.idAssigneurDeTache = assigneurDeTache.getId();
    }

}
