package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Priorite;
import aitahmed.hamza.gestionnairedestachesservice.Enum.StatutTache;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne @JsonManagedReference
    private HistoriqueStatut historiqueStatut;

    @ManyToOne @JsonBackReference
    private Projet projetDeTache;

    @ManyToOne @JsonIgnore
    private Utilisateur assigneurDeTache;

    //============ Les Methodes =============//

    public void setStatutTache(StatutTache statutTache) {
        this.statutTache = statutTache;
        this.historiqueStatut.ajouterStatut(statutTache);
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
//        System.out.println("Change Utilisateur " +  this.assigneurDeTache.getId + " ==> " + assigneurDeTache.getId());
        this.assigneurDeTache = assigneurDeTache;
        this.idAssigneurDeTache = assigneurDeTache.getId();
    }

}
