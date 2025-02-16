package aitahmed.hamza.gestionnairedestachesservice.entity;

import aitahmed.hamza.gestionnairedestachesservice.enumeration.Niveau;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
    public class CompetenceRequise {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String nom;

        @Enumerated(EnumType.STRING)
        private Niveau niveau;

        //============ Relation =============//

        @NonNull
        @ManyToOne
        private Competence competence;

        @ManyToOne
        private ListCompetencesRequise listCompetencesRequise;

   //============ Les Methodes =============//

        public void setCompetences(Competence competences) {
            this.competence = competences;
            this.nom = competences.getNom();
        }

        @JsonIgnore
        public ListCompetencesRequise getListDesCompetencesRequise() {
            return listCompetencesRequise;
        }
    }
