package aitahmed.hamza.gestionnairedestachesservice.repository;

import aitahmed.hamza.gestionnairedestachesservice.enumeration.StatutTache;
import aitahmed.hamza.gestionnairedestachesservice.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TacheRepository extends JpaRepository<Tache,Integer>{

    List<Tache> findTachesByProjetDeTacheId(@Param("id") Integer id);

    List<Tache> findTachesByProjetDeTacheIdAndStatutTache(@Param("id") Integer id , StatutTache statutTache);

    Tache findTacheById(Integer id);

    Tache findById(int id);

}
