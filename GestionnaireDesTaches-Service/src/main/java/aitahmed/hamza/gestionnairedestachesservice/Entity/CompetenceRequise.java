package aitahmed.hamza.gestionnairedestachesservice.Entity;

import aitahmed.hamza.gestionnairedestachesservice.Enum.Niveau;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

        private Integer idListCompetencesRequise;

        //============ Relation =============//

        @ManyToOne
        @JoinColumn(name = "Competence_Id", nullable = false)
        private Competence competence;

        @ManyToOne
        private ListCompetencesRequise ListDesCompetencesRequise;

   //============ Les Methodes =============//

        public void setCompetenceDeProjet(ListCompetencesRequise listcompetenceDeProjet) {
            this.ListDesCompetencesRequise = listcompetenceDeProjet;
            this.idListCompetencesRequise = listcompetenceDeProjet.getId();
        }

        public void setCompetences(Competence competences) {
            this.competence = competences;
            this.nom = competences.getNom();
        }

        @JsonIgnore
        public ListCompetencesRequise getListDesCompetencesRequise() {
            return ListDesCompetencesRequise;
        }
    }
