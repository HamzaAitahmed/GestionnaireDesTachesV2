package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Niveau;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompetenceUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    private Integer UtilisateurId;

    //============ Relation =============//

    @ManyToOne
    private Utilisateur competenceDeUtilisateur;

    @OneToOne
    private Competence competences;
    //============ Les Methodes =============//

    public void setcompetenceDeUtilisateur(Utilisateur competenceDeUtilisateur) {
        this.competenceDeUtilisateur = competenceDeUtilisateur;
        this.UtilisateurId = competenceDeUtilisateur.getId();
    }

    public void setCompetences(Competence competences) {
        this.competences = competences;
        this.nom = competences.getNom();
    }

}
