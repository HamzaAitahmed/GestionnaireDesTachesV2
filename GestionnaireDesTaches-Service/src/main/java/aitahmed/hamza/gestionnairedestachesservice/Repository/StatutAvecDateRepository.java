package aitahmed.hamza.gestionnairedestachesservice.Repository;

import aitahmed.hamza.gestionnairedestachesservice.Entity.StatutAvecDate;
import aitahmed.hamza.gestionnairedestachesservice.Enum.StatutTache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;

@RepositoryRestResource
public interface StatutAvecDateRepository extends JpaRepository<StatutAvecDate,Integer> {
    StatutAvecDate findByStatut(StatutTache statut);
    StatutAvecDate findStatutAvecDateById(int id);
    StatutAvecDate findByDateDeModification(LocalDate dateDeModification);

}