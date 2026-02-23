package aitahmed.hamza.gestionnairedestachesservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String token;              // The refresh token value

    private boolean revoked;           // For logout

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    @ManyToOne
    @JsonBackReference
    private Utilisateur proprietaireDuToken;

}
