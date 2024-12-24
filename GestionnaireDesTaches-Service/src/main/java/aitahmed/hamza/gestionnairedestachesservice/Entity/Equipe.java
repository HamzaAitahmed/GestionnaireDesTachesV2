package aitahmed.hamza.gestionnairedestachesservice.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;
import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Equipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String nom;

    private LocalDate dateDeCreation;

    private Integer idChefEquipe;

    //============ Relation =============//

    @ManyToOne
    private Utilisateur chefEquipe;

    @OneToMany(mappedBy = "equipeDeProjet")
    private Collection<Projet> projetsEquipe;

    @ManyToMany
    private  Collection<Utilisateur> mesMembers;
    //============ Les Methodes =============//

    public void setChefEquipe(Utilisateur chefEquipe) {
        this.chefEquipe = chefEquipe;
        this.idChefEquipe = chefEquipe.getId();
    }
}
