package aitahmed.hamza.gestionnairedestachesservice.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class ListCompetencesUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idUtilisateur;

    //============ Relation =============//

    @OneToOne @JsonIgnore
    private Utilisateur utilisateur;

    @OneToMany( mappedBy = "ListDesCompetences")
    private List<CompetenceUtilisateur> CompetenceUtilisateur;

    //============ Les Methodes =============//

    public void setcompetenceDeUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        this.idUtilisateur = utilisateur.getId();
    }

}