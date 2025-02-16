package aitahmed.hamza.gestionnairedestachesservice.entity;

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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //============ Relation =============//

    @OneToOne @JsonBackReference
    private Utilisateur utilisateur;

    @OneToMany( mappedBy = "listCompetencesUtilisateur")
    private List<CompetenceUtilisateur> lesCompetencesUtilisateur;

    //============ Les Methodes =============//

}