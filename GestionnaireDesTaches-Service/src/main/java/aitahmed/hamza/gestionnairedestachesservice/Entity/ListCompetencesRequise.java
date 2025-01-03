package aitahmed.hamza.gestionnairedestachesservice.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne @JsonIgnore
    private Projet projet;

    //    @JsonManagedReference
    @OneToMany(mappedBy = "ListDesCompetencesRequise")
    private List<CompetenceRequise> CompetenceRequise;

    //============ Les Methodes =============//

    public void setcompetenceDeUtilisateur(Projet projet) {
        this.projet = projet;
        this.idProjet = projet.getId();
    }

}
