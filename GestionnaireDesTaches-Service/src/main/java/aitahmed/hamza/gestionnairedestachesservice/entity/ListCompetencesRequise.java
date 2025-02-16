package aitahmed.hamza.gestionnairedestachesservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //============ Relation =============//

    @OneToOne @JsonIgnore
    private Projet projet;

    //    @JsonManagedReference
    @OneToMany(mappedBy = "listCompetencesRequise")
    private List<CompetenceRequise> lesCompetencesRequise;

    //============ Les Methodes =============//

}
