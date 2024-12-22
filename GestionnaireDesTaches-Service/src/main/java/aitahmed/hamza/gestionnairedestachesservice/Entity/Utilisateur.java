package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Role;
import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String email;

    private double salaire;

    private String nom, prenom, username, password, gender;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

//    @Temporal(TemporalType.DATE)
    private Date dateInscription, anneeExpeience;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "photo")
    private String profilePicture;

    //============ Relation =============//

    @OneToMany(mappedBy = "chefProjet")
    private Collection<Projet> mesProjets;

    @OneToMany(mappedBy = "competenceDeUtilisateur")
    private Collection<CompetenceUtilisateur> mesCompetrence;

    @OneToMany(mappedBy = "assigneurDeTache")
    private Collection<Tache> mesTaches;

    @OneToMany(mappedBy = "recepteur")
    private Collection<Notification> notifications;

    @OneToMany(mappedBy = "chefEquipe")
    private Collection<Equipe> mesEquipes;

    @ManyToMany(mappedBy = "mesMembers")
    private Collection<Equipe> membreEquipe;

}
