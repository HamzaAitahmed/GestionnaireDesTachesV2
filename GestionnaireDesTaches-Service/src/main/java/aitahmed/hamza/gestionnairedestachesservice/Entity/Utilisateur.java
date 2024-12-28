package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String email;

    private double salaire;

    private String nom, prenom, username, password, gender;

    private LocalDate dateOfBirth;

    private LocalDate dateInscription;

    private int anneeExpeience;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "photo")
    private String profilePicture;

    private Integer idListMesCompetences;

    //============ Relation =============//

    @OneToOne
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

    @ManyToMany(mappedBy = "mesMembers") @JsonBackReference
    private Collection<Equipe> membreEquipe;

}
