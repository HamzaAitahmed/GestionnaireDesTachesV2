package aitahmed.hamza.gestionnairedestachesservice.Repository;

import aitahmed.hamza.gestionnairedestachesservice.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface ProjetRepository extends JpaRepository<Projet,Integer> {
    Projet findProjetById(Integer id);

    Projet findById(int id);

    List<Projet> findProjetsByChefProjetId(@Param("id") Integer id);

    List<Projet> findProjetsByequipeDeProjetIsNull();


    @Query("SELECT p FROM Projet p JOIN Equipe t ON p.equipeDeProjet = t JOIN Utilisateur u ON t.chefEquipe = u OR t IN ( SELECT tm.membreEquipe  FROM t.mesMembers tm WHERE u = tm ) WHERE u.id = :id")
    List<Projet> findEquipeDeProjetByUserId(Integer id); // il recupere les projets où l'utilisateur est membre ou chef d'équipe affecté au projet et même s'il est le chef du projet

//    List<Projet> findProjetsByChefProjetIdAndIdIn(Integer id); // il recupere les projets où l'utilisateur est membre ou chef d'équipe affecté au projet et même s'il est le chef du projet

    @Query("SELECT p FROM Projet p JOIN Equipe t ON p.chefProjet.id != :id AND p.equipeDeProjet = t JOIN Utilisateur u ON t.chefEquipe = u OR t IN ( SELECT tm.membreEquipe  FROM t.mesMembers tm WHERE u = tm ) WHERE u.id = :id")
    List<Projet> findOtherProjectByUserId(Integer id);  // il recupere les projets où l'utilisateur est membre ou chef d'équipe affecté au projet mais il n'est pas le chef du projet

    @Query("SELECT p FROM Projet p JOIN Equipe t ON p.equipeDeProjet = t Or p.chefProjet.id = :id JOIN Utilisateur u ON  t.chefEquipe = u OR t IN ( SELECT tm.membreEquipe  FROM t.mesMembers tm WHERE u = tm ) WHERE u.id = :id  ")
    List<Projet> findAllProjectByUserId(Integer id);    // il recupere les projets où l'utilisateur est un chef du projet, aussi membre ou chef d'équipe affecté au projet

//    SELECT p.*
//    FROM Projet p
//    JOIN Equipe t ON p.project_team_id = t.id
//    JOIN User u ON t.leader_id = u.id OR t.id IN (SELECT y.teams_id FROM team_members y WHERE u.id = y.members_id)
//    WHERE u.id = 1;

}
