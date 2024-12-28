package aitahmed.hamza.gestionnairedestachesservice.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ListCompetencesRequise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idProjet;

    //============ Relation =============//

    @OneToOne
    private Projet projet;

    @OneToMany(mappedBy = "ListDesCompetencesRequise")
    @JsonBackReference
    private List<CompetenceRequise> competenceRequise;

    //============ Les Methodes =============//

    public void setcompetenceDeUtilisateur(Projet projet) {
        this.projet = projet;
        this.idProjet = projet.getId();
    }

}
