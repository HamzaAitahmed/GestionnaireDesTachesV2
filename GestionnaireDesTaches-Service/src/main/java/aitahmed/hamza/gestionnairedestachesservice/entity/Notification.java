package aitahmed.hamza.gestionnairedestachesservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dateDeCreation, dateLu;

    private boolean lu;

    private String titre,message;

    private Integer idRecepteur;

    //============ Relation =============//

    @ManyToOne
    private Utilisateur recepteur;

}
