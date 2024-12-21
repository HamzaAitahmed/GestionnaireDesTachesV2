package aitahmed.hamza.gestionnairedestachesservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Equipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(unique=true)
    private String Nom;

    private Date dateDeCreation;

    //============ Relation =============//

    @ManyToOne
    private Utilisateur ChefEquipe;

    @OneToMany(mappedBy = "EquipeDeProjet")
    private Collection<Projet> ProjetsEquipe;

    @ManyToMany
    private  Collection<Utilisateur> MesMembers;
    
}
