package aitahmed.hamza.gestionnairedestachesservice.Repository;

import aitahmed.hamza.gestionnairedestachesservice.entity.ListCompetencesUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ListCompetencesUtilisateurRepository extends JpaRepository<ListCompetencesUtilisateur,Integer> {
    ListCompetencesUtilisateur findListCompetencesUtilisateurById(int id);
}
