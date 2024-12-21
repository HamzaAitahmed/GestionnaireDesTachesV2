package aitahmed.hamza.gestionnairedestachesservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private Date dateDeCreation, dateEnvoyer, dateRecever, dateLu;

    private boolean Lu;

    private String Titre,Message;

    //============ Relation =============//

    @OneToOne
    private Utilisateur QuiAEnvoyer;

    @OneToOne
    private Utilisateur Destinataire;
}
