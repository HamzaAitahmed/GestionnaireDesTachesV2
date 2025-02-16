package aitahmed.hamza.gestionnairedestachesservice.entity;

import aitahmed.hamza.gestionnairedestachesservice.enumeration.Niveau;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class CompetenceUtilisateur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    //============ Relation =============//

    @NotNull
    @ManyToOne
    private Competence competence;

    @ManyToOne
    private ListCompetencesUtilisateur listCompetencesUtilisateur;

    //============ Les Methodes =============//

    public void setCompetence(Competence competence) {
        this.competence = competence;
        this.nom = competence.getNom();
    }

    @JsonIgnore
    public ListCompetencesUtilisateur getListCompetencesUtilisateur() {
        return listCompetencesUtilisateur;
    }
}
