package aitahmed.hamza.gestionnairedestachesservice.repository;

import aitahmed.hamza.gestionnairedestachesservice.entity.CompetenceRequise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompetenceRequiseRepository extends JpaRepository<CompetenceRequise,Integer> {
    CompetenceRequise findCompetenceRequiseById(int id);
}
