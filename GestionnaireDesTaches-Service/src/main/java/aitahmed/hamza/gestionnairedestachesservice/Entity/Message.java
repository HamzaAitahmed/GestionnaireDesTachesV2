package aitahmed.hamza.gestionnairedestachesservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date dateDeCreation, dateEnvoyer, dateRecever, dateLu;

    private boolean lu;

    private String titre,message;

    //============ Relation =============//

    @OneToOne
    private Utilisateur emmetteur;

    @OneToOne
    private Utilisateur recepteur ;
}
