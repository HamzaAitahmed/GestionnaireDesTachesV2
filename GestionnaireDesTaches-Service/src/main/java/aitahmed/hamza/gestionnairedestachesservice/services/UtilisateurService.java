package aitahmed.hamza.gestionnairedestachesservice.services;


import aitahmed.hamza.gestionnairedestachesservice.entity.Utilisateur;
import aitahmed.hamza.gestionnairedestachesservice.enumeration.Role;
import aitahmed.hamza.gestionnairedestachesservice.repository.UtilisateurRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    UtilisateurService(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Utilisateur> getToutesLesUtilisateurs(){
        return utilisateurRepository.findAll();
    }
    
    public Utilisateur getUtilisateurByEmail(String email){
        return utilisateurRepository.findByEmail(email);
    }

    public Utilisateur getUtilisateurById(int id){
        return utilisateurRepository.findUtilisateurById(id);
    }

    public Utilisateur creerUtilisateur(Utilisateur utilisateur){
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        utilisateur.setRole(Role.USER);
        utilisateur.setProfilePicture("assets/images/user/inconnu.jpg");
        Utilisateur newUtilisateur = enregistrerUtilisateur(utilisateur);
        utilisateurRepository.flush();
        return newUtilisateur;
    }
    
    public Utilisateur creerUtilisateurVide(){
        Utilisateur newUtilisateur = enregistrerUtilisateur(new Utilisateur());
        utilisateurRepository.flush();
        return newUtilisateur;
    }

    public Utilisateur enregistrerUtilisateur(Utilisateur savedUtilisateur)
    {
        return utilisateurRepository.save(savedUtilisateur);
    }

    public Utilisateur ajouterUtilisateur(Utilisateur utilisateurAjouter) {
        return creerUtilisateur(utilisateurAjouter);
    }

    public Utilisateur modifierUtilisateur(int utilisateurId, Utilisateur nouvelleModificationUtilisateur)
    {
        Utilisateur utilisateurModifier = getUtilisateurById(utilisateurId);
        copierDepuis(nouvelleModificationUtilisateur, utilisateurModifier);
        return enregistrerUtilisateur(utilisateurModifier);
    }

    public boolean supprimerUtilisateur(int utilisateurId)
    {
        utilisateurRepository.deleteById(utilisateurId);
        return true;
    }

    public void copierDepuis(Utilisateur source, Utilisateur target) {
        if (source.getEmail() != null) target.setEmail(source.getEmail());
        if (source.getSalaire() != 0) target.setSalaire(source.getSalaire());
        if (source.getNom() != null) target.setNom(source.getNom());
        if (source.getPrenom() != null) target.setPrenom(source.getPrenom());
        if (source.getUsername() != null) target.setUsername(source.getUsername());
        if (source.getPassword() != null) target.setPassword(source.getPassword());
        if (source.getGender() != null) target.setGender(source.getGender());
        if (source.getDateOfBirth() != null) target.setDateOfBirth(source.getDateOfBirth());
        if (source.getDateInscription() != null) target.setDateInscription(source.getDateInscription());
        if (source.getAnneeExperience() != 0) target.setAnneeExperience(source.getAnneeExperience());
        if (source.getRole() != null) target.setRole(source.getRole());
        if (source.getProfilePicture() != null) target.setProfilePicture(source.getProfilePicture());

        //============ Relation =============//

        if (source.getListMesCompetences() != null) target.setListMesCompetences(source.getListMesCompetences());
        if (source.getMesProjets() != null) target.setMesProjets(source.getMesProjets());
        if (source.getMesTaches() != null) target.setMesTaches(source.getMesTaches());
        if (source.getMesEquipes() != null) target.setMesEquipes(source.getMesEquipes());
        if (source.getMembreDansLEquipe() != null) target.setMembreDansLEquipe(source.getMembreDansLEquipe());
    }



}


