package aitahmed.hamza.gestionnairedestachesservice.repository;

import aitahmed.hamza.gestionnairedestachesservice.entity.CompetenceUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompetenceUtilisateurRepository extends JpaRepository<CompetenceUtilisateur,Integer> {
    CompetenceUtilisateur findCompetenceUtilisateurById(int id);
}