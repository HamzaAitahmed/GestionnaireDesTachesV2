package aitahmed.hamza.gestionnairedestachesservice.entity;

import aitahmed.hamza.gestionnairedestachesservice.enumeration.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Utilisateur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email
    @Column(unique=true)
    private String email;

    private double salaire;

    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String gender;

    private LocalDate dateOfBirth;
    private LocalDate dateInscription;
    private int anneeExperience;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Column(name = "photo")
    private String profilePicture;

    //============ Relation =============//

    @OneToOne @JsonManagedReference
    private ListCompetencesUtilisateur listMesCompetences;

    @OneToMany(mappedBy = "chefProjet") @JsonIgnore
    private Collection<Projet> mesProjets;

    @OneToMany(mappedBy = "assigneurDeTache") @JsonIgnore
    private Collection<Tache> mesTaches;

//    @OneToMany(mappedBy = "recepteur")
//    private Collection<Notification> notifications;

    @OneToMany(mappedBy = "chefEquipe")
    @JsonManagedReference
    private Collection<Equipe> mesEquipes;

    @ManyToMany(mappedBy = "lesMembresDEquipe") @JsonBackReference
    private Collection<Equipe> membreDansLEquipe;

    //============ Les Methodes =============//

    public void setListMesCompetences(ListCompetencesUtilisateur listMesCompetences) {
        this.listMesCompetences = listMesCompetences;
        this.listMesCompetences.setUtilisateur(this);
    }

}
