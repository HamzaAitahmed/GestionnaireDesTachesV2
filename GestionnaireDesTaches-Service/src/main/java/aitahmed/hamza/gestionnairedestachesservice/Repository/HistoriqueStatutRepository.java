package aitahmed.hamza.gestionnairedestachesservice.Repository;

import aitahmed.hamza.gestionnairedestachesservice.entity.HistoriqueStatut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HistoriqueStatutRepository extends JpaRepository<HistoriqueStatut,Integer> {
    HistoriqueStatut findHistoriqueStatutById(int id);
}