package aitahmed.hamza.gestionnairedestachesservice.model;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Role;
import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(unique=true)
    private String Email;

    private double Salaire;

    private String Nom, Prenom, Username, Password, Gender;

    @Temporal(TemporalType.DATE)
    private Date DateOfBirth;

//    @Temporal(TemporalType.DATE)
    private Date DateInscription, AnneeExpeience;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role Role;

    @Column(name = "photo")
    private String ProfilePicture;

    //============ Relation =============//

    @OneToMany(mappedBy = "ChefProjet")
    private Collection<Projet> MesProjets;

    @ManyToMany
    private Collection<Competence> MesCompetence;

    @OneToMany(mappedBy = "assignee")
    private Collection<Tache> MesTaches;

    @OneToMany(mappedBy = "ChefEquipe")
    private Collection<Equipe> MesEquipes;

    @ManyToMany(mappedBy = "MesMembers")
    private Collection<Equipe> MembreEquipe;

}
