package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Niveau;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class CompetenceRequise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    private Integer ProjetId;

    //============ Relation =============//

    @ManyToOne
    private Projet competenceDeProjet;

    @OneToOne
    private Competence competences;

    //============ Les Methodes =============//

    public void setCompetenceDeProjet(Projet competenceDeProjet) {
        this.competenceDeProjet = competenceDeProjet;
        this.ProjetId = competenceDeProjet.getId();
    }

    public void setCompetences(Competence competences) {
        this.competences = competences;
        this.nom = competences.getNom();
    }
}
