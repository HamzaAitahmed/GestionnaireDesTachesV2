package aitahmed.hamza.gestionnairedestachesservice.repository;

import aitahmed.hamza.gestionnairedestachesservice.entity.ListCompetencesRequise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ListCompetencesRequiseRepository extends JpaRepository<ListCompetencesRequise,Integer> {
    ListCompetencesRequise findListCompetencesRequiseById(int id);
}
