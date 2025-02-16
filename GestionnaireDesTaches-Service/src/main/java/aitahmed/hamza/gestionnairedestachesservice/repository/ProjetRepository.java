package aitahmed.hamza.gestionnairedestachesservice.repository;

import aitahmed.hamza.gestionnairedestachesservice.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProjetRepository extends JpaRepository<Projet,Integer> {
    Projet findProjetById(Integer id);

    Projet findById(int id);

    List<Projet> findProjetsByChefProjetId(@Param("id") int id);

    List<Projet> findProjetsByEquipeDuProjetIsNull();


    @Query("SELECT p FROM Projet p JOIN Equipe t ON p.equipeDuProjet = t JOIN Utilisateur u ON t.chefEquipe = u OR t IN ( SELECT tm.membreDansLEquipe  FROM t.lesMembresDEquipe tm WHERE u = tm ) WHERE u.id = :id")
    List<Projet> findEquipeDuProjetByUserId(Integer id); // il recupere les projets où l'utilisateur est membre ou chef d'équipe affecté au projet et même s'il est le chef du projet

//    @Query("SELECT p FROM Projet p JOIN Equipe t ON p.chefProjet.id != :id AND p.equipeDuProjet = t JOIN Utilisateur u ON t.chefEquipe = u OR t IN ( SELECT tm.membreDansLEquipe  FROM t.lesMembresDEquipe tm WHERE u = tm ) WHERE u.id = :id")
    @Query("SELECT p FROM Projet p WHERE p.equipeDuProjet.chefEquipe.id = :id  OR :id IN (SELECT u.id FROM Equipe t JOIN t.lesMembresDEquipe u WHERE t = p.equipeDuProjet)")
    List<Projet> findOtherProjectByUserId(int id);  // il recupere les projets où l'utilisateur est membre ou chef d'équipe affecté au projet mais il n'est pas le chef du projet

    @Query("SELECT p FROM Projet p WHERE p.chefProjet.id = :id  OR p.equipeDuProjet.chefEquipe.id = :id  OR :id IN (SELECT u.id FROM Equipe t JOIN t.lesMembresDEquipe u WHERE t = p.equipeDuProjet)")
    List<Projet> findAllProjectByUserId(int id);    // il recupere les projets où l'utilisateur est un chef du projet, aussi membre ou chef d'équipe affecté au projet

}
