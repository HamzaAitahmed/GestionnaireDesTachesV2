package aitahmed.hamza.gestionnairedestachesservice.services;

import aitahmed.hamza.gestionnairedestachesservice.authentification.CustomUserDetails;
import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilisateurService utilisateurService;

    public CustomUserDetailsService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {

        Utilisateur utilisateur = utilisateurService.getUtilisateurByEmail(email) ;

        return new CustomUserDetails(utilisateur);
    }
}
