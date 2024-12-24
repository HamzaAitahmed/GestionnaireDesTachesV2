package aitahmed.hamza.gestionnairedestachesservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dateDeCreation, dateEnvoyer, dateRecever, dateLu;

    private boolean lu;

    private String titre,message;

    private Integer idEmmetteur;

    private Integer idRecepteur;

    //============ Relation =============//

    @OneToOne
    private Utilisateur emmetteur;

    @OneToOne
    private Utilisateur recepteur ;
}
