package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Niveau;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
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

    private Integer idListDesCompetences;

    //============ Relation =============//

    @ManyToOne
    @JoinColumn(name = "Competence_Id", nullable = false)
    private Competence competence;

    @ManyToOne
    private ListCompetencesUtilisateur ListDesCompetences;

    //============ Les Methodes =============//

    public void setListDesCompetences(ListCompetencesUtilisateur listDesCompetencesUtilisateur) {
        this.ListDesCompetences = listDesCompetencesUtilisateur;
        this.idListDesCompetences = listDesCompetencesUtilisateur.getId();
    }

    public void setCompetences(Competence competences) {
        this.competence = competences;
        this.nom = competences.getNom();
    }

    @JsonIgnore
    public ListCompetencesUtilisateur getListDesCompetences() {
        return ListDesCompetences;
    }

    @Override
    public String toString() {
        return "CompetenceUtilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", niveau=" + niveau +
                ", idListDesCompetences=" + idListDesCompetences +
                ", competence=" + competence.toString() +
                '}';
    }
}
