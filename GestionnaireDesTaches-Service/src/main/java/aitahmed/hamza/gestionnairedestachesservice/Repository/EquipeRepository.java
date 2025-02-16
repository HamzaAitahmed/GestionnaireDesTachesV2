package aitahmed.hamza.gestionnairedestachesservice.Repository;

import aitahmed.hamza.gestionnairedestachesservice.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EquipeRepository extends JpaRepository<Equipe,Integer>{

//    @Query("SELECT p.equipeDeProjet FROM Projet p WHERE p.equipeDeProjet IS NOT NULL ")
//    List<Equipe> findEquipesByProjetNotNull();

//    List<Equipe> findEquipesByLesProjetsDEquipeIsNotNull();

    List<Equipe> findEquipesByLesProjetsDEquipeIsNull();

    Equipe findById(int id);

    Equipe findEquipeById(Integer id);

    List<Equipe> findEquipesByChefEquipeId(@Param("id") Integer id);

    List<Equipe> findEquipesByChefEquipe_Id(@Param("id") Integer id);

//    @Query("SELECT t FROM Equipe t WHERE t.chefEquipe.id = :id")
//    List<Equipe> findMesEquipesByChefEquipe(@Param("id") Integer id);


    @Query("SELECT t FROM Equipe t WHERE t In (select u.mesEquipes from Utilisateur u  where u.id = :id ) or t.chefEquipe.id = :id ")
    List<Equipe> findMesEquipesByUser(@Param("id") Integer id);

}
