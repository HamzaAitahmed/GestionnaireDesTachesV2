package aitahmed.hamza.gestionnairedestachesservice.Repository;

import aitahmed.hamza.gestionnairedestachesservice.Enum.StatutTache;
import aitahmed.hamza.gestionnairedestachesservice.Entity.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface TacheRepository extends JpaRepository<Tache,Integer>{

    List<Tache> findTachesByProjetDeTacheId(@Param("id") Integer id);

    List<Tache> findTachesByProjetDeTacheIdAndStatutTache(@Param("id") Integer id , StatutTache statutTache);

    Tache findTacheById(Integer id);

    Tache findById(int id);


}
