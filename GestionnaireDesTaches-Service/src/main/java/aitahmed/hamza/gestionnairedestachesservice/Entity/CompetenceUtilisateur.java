package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Niveau;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompetenceUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    //============ Relation =============//

    @ManyToOne
    private Utilisateur competenceDeUtilisateur;

    @OneToOne
    private Competence competences;

}
