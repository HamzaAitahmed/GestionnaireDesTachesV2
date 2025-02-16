package aitahmed.hamza.gestionnairedestachesservice.services;

import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUtilisateurDetailleService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    public CustomeUtilisateurDetailleService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if(utilisateur == null){
            throw new UsernameNotFoundException("No user found with email");
        }
        return  org.springframework.security.core.userdetails.User.builder()
                        .username(utilisateur.getUsername())
                        .password(utilisateur.getPassword())
                        .roles("USER")
                        .build();
    }
}


